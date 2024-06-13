import {useRouter} from 'next/navigation';
import {useDispatch} from 'react-redux';
import {useForm} from "react-hook-form";
import {z} from 'zod';
import {zodResolver} from "@hookform/resolvers/zod";
import {toast} from "react-hot-toast";
import axios from "../../../../lib/axios";
import {setToken} from "@/store/tokenSlice";
import {setID} from "@/store/idSlice";

const loginSchema = z.object({
    email: z.string().email({message: 'Nieprawidłowy adres email'}),
    password: z.string({message: 'Nieprawidłowe hasło'})
});

export default function LoginForm() {
    const dispatch = useDispatch();
    const router = useRouter();
    const {
        register,
        handleSubmit,
        formState: {errors, isSubmitting},
        reset,
    } = useForm({
        resolver: zodResolver(loginSchema),
    });

    const onSubmit = async (e) => {
        const email = e.email;
        const password = e.password;
        const formData = {
            email,
            password
        }
        try {
            const response = await axios.post('auth/login', formData);
            if (response.status === 200) {
                dispatch(setToken(response.data.token));
                dispatch(setID(response.data.id));
                router.push('/');
            } else {
                toast.error('Błąd logowania. Spróbuj ponownie.');
            }
        } catch (error) {
            toast.error('Błąd logowania. Spróbuj ponownie.');
        }
        reset();
    };

    return (
        <div className='absolute max-w-md w-full p-6'>
            <h1 className='text-3xl font-semibold mb-6 text-black text-center'>
                Zaloguj się
            </h1>
            <form onSubmit={handleSubmit(onSubmit)}
                  className='space-y-4'>
                <label htmlFor='email'
                       className='block text-sm font-medium text-gray-700'>Email</label>
                <input
                    id={'email'}
                    className='mt-1 p-2 w-full border rounded-md focus:border-gray-200 focus:outline-none focus:ring-1 focus:ring-offset-1 focus:ring-gray-300 transition-colors duration-300 hover:shadow-md hover:shadow-gray-300/20' {...register('email')}
                    type='email'/>
                {errors.email && (
                    <p className='text-red-500'>{`${errors.email.message}`}</p>
                )}
                <label
                    className='block text-sm font-medium text-gray-700'
                    htmlFor='password'>Hasło</label>
                <input
                    id={'password'}
                    className='mt-1 p-2 w-full border rounded-md focus:border-gray-200 focus:outline-none focus:ring-1 focus:ring-offset-1 focus:ring-gray-300 transition-colors duration-300 hover:shadow-md hover:shadow-gray-300/20' {...register('password')}
                    type='password'/>
                {errors.password && (
                    <p className='text-red-500'>{`${errors.password.message}`}</p>
                )}
                <button type={"submit"}
                        aria-label='Wyślij formularz logowania'
                        className='w-full font-semibold p-2 rounded-md focus:bg-blue-500 focus:outline-none focus:ring-1 focus:ring-offset-2 focus:ring-blue-500 bg-blue-500 border border-blue-600 text-white hover:bg-blue-600 hover:shadow-lg hover:shadow-blue-600/20 hover:text-white duration-300'
                        disabled={isSubmitting}>
                    Zaloguj
                </button>
            </form>
        </div>
    );
}
