import { checkEmail } from '@/app/services/emailService';
import { useState } from 'react';
import axios from '../../../../lib/axios';

export default function RegisterForm() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (
      username === '' ||
      email === '' ||
      password === '' ||
      confirmPassword === ''
    ) {
      alert(
        'Nie można zarejestrować. Wymagane jest podanie adresu email i hasła'
      );
      return;
    }
    if (password !== confirmPassword) {
      alert('Nie można zarejestrować. Hasła nie pasują do siebie.');
      return;
    }
    if (password.length < 8) {
      alert('Nie można zarejestrować. Hasło musi mieć co najmniej 8 znaków.');
      return;
    }
    const isEmailValid = await checkEmail(email);
    if (!isEmailValid) {
      alert('Nie można zarejestrować. Nieprawidłowy adres email.');
      return;
    }
    try {
      const response = await axios.post('/auth/register', {
        email,
        password,
      });
      if (response.status === 200) {
        alert('Konto zostało utworzone. Zaloguj się.');
        return;
      }
    } catch (error) {
      alert('Konto z takim adresem email już istnieje. Zaloguj się.');
    }
  };

  return (
    <div className='absolute  max-w-md w-full p-6'>
      <h1 className='text-3xl font-semibold mb-6 text-black text-center'>
        Utwórz konto
      </h1>
      <h1 className='text-sm font-semibold mb-6 text-gray-500 text-center'>
        Twój głos ma znaczenie!
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
            autoComplete='username'
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
            autoComplete='email'
            required
          />
        </div>
        <div>
          <label
            htmlFor='confirmPassword'
            className='block text-sm font-medium text-gray-700'
          >
            Potwierdź hasło
          </label>
          <input
            type='password'
            id='confirmPassword'
            name='confirmPassword'
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            className='mt-1 p-2 w-full border rounded-md focus:border-gray-200 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-300 transition-colors duration-300'
            aria-required='true'
            autoComplete='new-password'
            required
          />
        </div>
        <div>
          <button
            type='submit'
            aria-label='Submit Register Form'
            className='w-full text-white p-2 rounded-md bg-blue-600 hover:bg-blue-700 focus:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-600 transition-colors duration-300'
          >
            {' '}
            Register
          </button>
        </div>
      </form>
    </div>
  );
}
