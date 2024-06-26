import { useForm } from 'react-hook-form';
import { z } from 'zod';
import { zodResolver } from '@hookform/resolvers/zod';
import { toast } from 'react-hot-toast';
import { setToken } from '@/store/tokenSlice';
import { setID } from '@/store/idSlice';
import axios from '../../../../lib/axios';
import '../input.css';
import {useDispatch} from "react-redux";
import {useRouter} from "next/navigation";

const registerSchema = z.object({
    email: z.string().email({ message: 'Nieprawidłowy adres email' }),
    password: z.string().min(8, 'Hasło musi mieć minimum 8 znaków'),
    confirmPassword: z.string(),
}).refine((data) => data.password === data.confirmPassword, {
    message: 'Hasła nie są identyczne',
    path: ['confirmPassword'],
});

export default function RegisterForm() {
    const dispatch = useDispatch();
    const router = useRouter();

    const {
        register,
        handleSubmit,
        formState: { errors, isSubmitting },
        reset,
    } = useForm({
        resolver: zodResolver(registerSchema),
    });

    const onSubmit = async (e) => {
        const email = e.email;
        const password = e.password;
        const formData = {
            email,
            password,
        };
        try {
            const registerResponse = await axios.post('https://localhost:8080/api/auth/register', formData);
            if (registerResponse.status === 201) {
                const loginResponse = await axios.post('https://localhost:8080/api/auth/login', formData);
                if (loginResponse.status === 200) {
                    dispatch(setToken(loginResponse.data.token));
                    dispatch(setID(loginResponse.data.id));
                    router.push('/');
                    toast.success('Rejestracja zakończona sukcesem. Zalogowano.');
                }
            }
        } catch (error) {
            console.error(error);
            toast.error('Konto z takim adresem email już istnieje. Zaloguj się.');
        }
    };

    return (
        <div className='absolute max-w-md w-full p-6'>
            <h1 className='text-3xl font-semibold mb-6 text-black text-center'>Utwórz konto</h1>
            <h1 className='text-sm font-semibold mb-6 text-gray-500 text-center'>Twój głos ma znaczenie!</h1>
            <form onSubmit={handleSubmit(onSubmit)} className='space-y-4'>
                <div className='relative'>
                    <label htmlFor='email' className='block uppercase text-sm font-bold text-gray-700'>
                        Email
                    </label>
                    <input
                        id='email'
                        className={`mt-1 p-2 w-full border rounded shadow focus:border-gray-200 focus:outline-none focus:ring-1 focus:ring-offset-1 focus:ring-gray-300 transition-colors duration-300 ${
                            errors.email ? 'shake border-red-500 focus:border-red-200 focus:ring-red-300' : ''
                        }`}
                        {...register('email')}
                        placeholder={'Podaj swój email'}
                        type='email'
                    />
                    {errors.email && (
                        <span className='absolute right-2 top-0 mt-1 text-xs text-red-500'>
                            {errors.email.message}
                        </span>
                    )}
                </div>

                <div className='relative'>
                    <label htmlFor='password' className='block uppercase text-sm font-bold text-gray-700'>
                        Hasło
                    </label>
                    <input
                        id='password'
                        className={`mt-1 p-2 w-full border rounded shadow focus:border-gray-200 focus:outline-none focus:ring-1 focus:ring-offset-1 focus:ring-gray-300 transition-colors duration-300 ${
                            errors.password ? 'shake border-red-500 focus:border-red-200 focus:ring-red-300' : ''
                        }`}
                        {...register('password')}
                        placeholder={'Utwórz swoje hasło'}
                        type='password'
                    />
                    {errors.password && (
                        <span className='absolute right-2 top-0 mt-1 text-xs text-red-500'>
                            {errors.password.message}
                        </span>
                    )}
                </div>

                <div className='relative'>
                    <label htmlFor='confirmPassword' className='block uppercase text-sm font-bold text-gray-700'>
                        Potwierdź hasło
                    </label>
                    <input
                        id='confirmPassword'
                        className={`mt-1 p-2 w-full border rounded shadow focus:border-gray-200 focus:outline-none focus:ring-1 focus:ring-offset-1 focus:ring-gray-300 transition-colors duration-300 ${
                            errors.confirmPassword ? 'shake border-red-500 focus:border-red-200 focus:ring-red-300' : ''
                        }`}
                        {...register('confirmPassword')}
                        placeholder={'Potwierdź swoje hasło'}
                        type='password'
                    />
                    {errors.confirmPassword && (
                        <span className='absolute right-2 top-0 mt-1 text-xs text-red-500'>
                            {errors.confirmPassword.message}
                        </span>
                    )}
                </div>

                <div>
                <button
                        type='submit'
                        className='w-full font-semibold p-2 rounded-md focus:bg-blue-500 focus:outline-none focus:ring-1 focus:ring-offset-2 focus:ring-blue-500 bg-blue-500 border border-blue-500 text-white hover:bg-blue-700 hover:shadow-lg hover:shadow-blue-700/20 hover:text-white duration-300'
                        disabled={isSubmitting}
                    >
                        Zarejestruj się
                    </button>
                </div>
            </form>
        </div>
    );
}
