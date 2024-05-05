import '@testing-library/jest-dom';
import { fireEvent, render } from '@testing-library/react';
import { Provider } from 'react-redux';
import LoginForm from '../src/app/components/LoginForm/LoginForm';
import { store } from '../src/store/store';

describe('LoginForm', () => {
  it('renders LoginForm and checks if input fields and button are present', () => {
    const { getByLabelText, getByText } = render(
      <Provider store={store}>
        <LoginForm />
      </Provider>
    );

    const emailInput = getByLabelText('Email');
    const passwordInput = getByLabelText('Hasło');
    const submitButton = getByText('Login');

    expect(emailInput).toBeInTheDocument();
    expect(passwordInput).toBeInTheDocument();
    expect(submitButton).toBeInTheDocument();
  });

  it('checks if input fields are working correctly', () => {
    const { getByLabelText, getByText } = render(
      <Provider store={store}>
        <LoginForm />
      </Provider>
    );

    const emailInput = getByLabelText('Email');
    const passwordInput = getByLabelText('Hasło');

    fireEvent.change(emailInput, { target: { value: 'test@example.com' } });
    fireEvent.change(passwordInput, { target: { value: 'password123' } });

    expect(emailInput.value).toBe('test@example.com');
    expect(passwordInput.value).toBe('password123');
  });
});
