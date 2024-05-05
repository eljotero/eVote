import { checkEmail } from '@/app/services/emailService';
import { useRouter } from 'next/navigation';
import { useState } from 'react';
import { useDispatch } from 'react-redux';
import axios from '../../../../lib/axios';
import { setToken } from '../../../store/tokenSlice';

export default function LoginForm() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const dispatch = useDispatch();
  const router = useRouter();

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (email === '' || password === '') {
      alert('Błąd logowania. Wymagane jest podanie adresu email i hasła.');
      return;
    }
    const isEmailValid = await checkEmail(email);
    if (!isEmailValid) {
      alert('Błąd logowania. Nieprawidłowy adres email.');
    }
    try {
      const response = await axios.post('/auth/login', {
        email,
        password,
      });
      if (response.status === 200) {
        dispatch(setToken(response.data.token));
        router.push('/map');
        return;
      } else {
        alert('Błąd logowania. Spróbuj ponownie.');
      }
    } catch (error) {
      alert('Błąd logowania. Spróbuj ponownie.');
    }
  };

  return (
    <div className='absolute max-w-md w-full p-6'>
      <h1 className='text-3xl font-semibold mb-6 text-black text-center'>
        Zaloguj się
      </h1>
      <form
        action='#'
        method='POST'
        onSubmit={handleSubmit}
        className='space-y-4'
      >
        <div>
          <label
            htmlFor='email'
            className='block text-sm font-medium text-gray-700'
          >
            Email
          </label>
          <input
            type='text'
            id='email'
            name='email'
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className='mt-1 p-2 w-full border rounded-md focus:border-gray-200 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-300 transition-colors duration-300'
            aria-required='true'
            autoComplete='email'
            required
          />
        </div>
        <div>
          <label
            htmlFor='password'
            className='block text-sm font-medium text-gray-700'
          >
            Hasło
          </label>
          <input
            type='password'
            id='password'
            name='password'
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className='mt-1 p-2 w-full border rounded-md focus:border-gray-200 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-300 transition-colors duration-300'
            aria-required='true'
            autoComplete='current-password'
            required
          />
        </div>
        <div>
          <button
            type='submit'
            aria-label='Submit Login Form'
            className='w-full text-white p-2 rounded-md bg-blue-600 hover:bg-blue-700 focus:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-600 transition-colors duration-300'
          >
            Zaloguj się
          </button>
        </div>
      </form>
    </div>
  );
}
