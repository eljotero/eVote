import { useRouter } from 'next/navigation';
import { useDispatch } from 'react-redux';
import { useForm } from 'react-hook-form';
import { z } from 'zod';
import { zodResolver } from '@hookform/resolvers/zod';
import { toast } from 'react-hot-toast';
import axios from '../../../../lib/axios';
import { setToken } from '@/store/tokenSlice';
import { setID } from '@/store/idSlice';
import '../input.css';

const loginSchema = z.object({
    email: z.string().email({ message: 'Nieprawidłowy adres email' }),
    password: z.string({ message: 'Nieprawidłowe hasło' }),
});

export default function LoginForm() {
    const dispatch = useDispatch();
    const router = useRouter();
    const {
        register,
        handleSubmit,
        formState: { errors, isSubmitting },
        reset,
    } = useForm({
        resolver: zodResolver(loginSchema),
    });

    const onSubmit = async (e) => {
        const email = e.email;
        const password = e.password;
        const formData = {
            email,
            password,
        };
        try {
            const response = await axios.post('https://localhost:8080/api/auth/login', formData);
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
            <h1 className='text-3xl font-semibold mb-6 text-black text-center'>Zaloguj się</h1>
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
                        placeholder={'Podaj swoje hasło'}
                        type='password'
                    />
                    {errors.password && (
                        <span className='absolute right-2 top-0 mt-1 text-xs text-red-500'>
                            {errors.password.message}
                        </span>
                    )}
                </div>

                <button
                    type='submit'
                    aria-label='Zaloguj'
                    className='w-full font-semibold p-2 rounded focus:bg-blue-500 focus:outline-none focus:ring-1 focus:ring-offset-2 focus:ring-blue-500 bg-blue-500 border border-blue-500 text-white hover:bg-blue-700 hover:shadow-lg hover:shadow-blue-700/20 hover:text-white duration-300'
                    disabled={isSubmitting}
                >
                    Zaloguj
                </button>
            </form>
        </div>
    );
}
