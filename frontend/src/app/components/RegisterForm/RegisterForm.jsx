import {useForm} from "react-hook-form";
import {z} from 'zod';
import {zodResolver} from "@hookform/resolvers/zod";
import {checkEmail} from "@/app/services/emailService";
import {toast} from "react-hot-toast";
import axios from "../../../../lib/axios";

const registerSchema = z.object({
    email: z.string(),
    password: z.string().min(8, 'Hasło musi mieć minimum 10 znaków'),
    confirmPassword: z.string(),
}).refine((data) => data.password === data.confirmPassword, {
    message: 'Hasła nie są identyczne',
    path: ['confirmPassword']
});

export default function RegisterForm() {
    const {
        register,
        handleSubmit,
        formState: {errors, isSubmitting},
        reset,
    } = useForm({
        resolver: zodResolver(registerSchema),
    });

    const onSubmit = async (e) => {
        const isEmailValid = await checkEmail(e.email);
        if (!isEmailValid) {
            toast.error('Nie można zarejestrować konta. Nieprawidłowy adres email.');
            return;
        }
        const email = e.email;
        const password = e.password;
        const formData = {
            email,
            password
        }
        try {
            const response = await axios.post('/auth/register', formData);
            if (response.status === 201) {
                toast.success('Konto zostało utworzone. Zaloguj się.');
                return;
            }
        } catch (error) {
            console.log(error);
            toast.error('Konto z takim adresem email już istnieje. Zaloguj się.');
        }
        reset();
    }

    return (<div className='absolute  max-w-md w-full p-6'>
        <h1 className='text-3xl font-semibold mb-6 text-black text-center'>
            Utwórz konto
        </h1>
        <h1 className='text-sm font-semibold mb-6 text-gray-500 text-center'>
            Twój głos ma znaczenie!
        </h1>
        <form onSubmit={handleSubmit(onSubmit)}
              className='space-y-4'>
            <div>
                <label htmlFor='email'
                       className='block text-sm font-medium text-gray-700'>Email</label>
                <input type='email' name='email'
                       id={'email'}
                       {...register('email')}
                       className='mt-1 p-2 w-full border rounded-md focus:border-gray-200 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-300 transition-colors duration-300'/>
                {errors.email && (
                    <p className='text-red-500'>{`${errors.email.message}`}</p>
                )}
            </div>
            <div>
                <label htmlFor='password'
                       className='block text-sm font-medium text-gray-700'>Hasło</label>
                <input type='password' name='password'
                       id={'password'}
                       className='mt-1 p-2 w-full border rounded-md focus:border-gray-200 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-300 transition-colors duration-300'
                       {...register('password')} />
                {errors.password && (
                    <p className='text-red-500'>{`${errors.password.message}`}</p>
                )}
            </div>
            <div>
                <label htmlFor='confirmPassword'
                       className='block text-sm font-medium text-gray-700'>Potwierdź
                    hasło</label>
                <input type='password' id={'confirmPassword'}
                       name='confirmPassword' {...register('confirmPassword')}
                       className='mt-1 p-2 w-full border rounded-md focus:border-gray-200 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-300 transition-colors duration-300'/>
                {errors.confirmPassword && (
                    <p className='text-red-500'>{`${errors.confirmPassword.message}`}</p>
                )}
            </div>
            <div>
                <button type='submit'
                        className='w-full text-white p-2 rounded-md bg-blue-600 hover:bg-blue-700 focus:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-600 transition-colors duration-300'>Zarejestruj
                    się
                </button>
            </div>

        </form>
    </div>);
}
