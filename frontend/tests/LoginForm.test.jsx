import '@testing-library/jest-dom';
import {fireEvent, render, screen} from '@testing-library/react';
import { Provider } from 'react-redux';
import LoginForm from '../src/app/components/LoginForm/LoginForm';
import { store } from '@/store/store';
import axios from 'lib/axios';
import {toast} from 'react-hot-toast';
import {act} from "react-dom/test-utils";
import {checkEmail} from "@/app/services/emailService";

jest.mock('lib/axios');
jest.mock('../src/app/services/emailService', () => ({
  checkEmail: jest.fn(),
}));
jest.mock('react-hot-toast', () => ({
  toast: {
    error: jest.fn(),
  },
}));

const TEST_EMAIL = 'test@example.com';
const TEST_PASSWORD = 'password123';
const TEST_BAD_EMAIL = 'testexamplecom';
const TEST_BAD_PASSWORD = 'password456';
const TEST_SHORT_PASSWORD = 'pass';

describe('LoginForm', () => {
  afterEach(() => {
    jest.clearAllMocks();
  });

  it('renders LoginForm and checks if input fields and button are present', () => {
    const { getByLabelText, getByText } = render(
      <Provider store={store}>
        <LoginForm />
      </Provider>
    );

    const emailInput = getByLabelText('Email');
    const passwordInput = getByLabelText('Hasło');
    const submitButton = getByText('Zaloguj');

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

    fireEvent.change(emailInput, { target: { value: TEST_EMAIL}});
    fireEvent.change(passwordInput, { target: { value: TEST_PASSWORD}});

    expect(emailInput.value).toBe(TEST_EMAIL);
    expect(passwordInput.value).toBe(TEST_PASSWORD);
  });

  it('calls handleSubmit when the form is submitted', async () => {
    checkEmail.mockResolvedValue(true);
    axios.post.mockResolvedValue({ status: 200 });

    const { getByLabelText, getByText } = render(
        <Provider store={store}>
          <LoginForm />
        </Provider>
    );

    const emailInput = getByLabelText('Email');
    const passwordInput = getByLabelText('Hasło');
    const submitButton = getByText('Zaloguj');

    fireEvent.change(emailInput, {target: {value: TEST_EMAIL}});
    fireEvent.change(passwordInput, {target: {value: TEST_PASSWORD}});

    await act(async () => {
      fireEvent.click(submitButton);
    });

    expect(axios.post).toHaveBeenCalledWith('/auth/login', {
      email: TEST_EMAIL,
      password: TEST_PASSWORD,
    });
  });

  it('shows an error when the email or password is empty', async () => {
    const {getByText} = render(
        <Provider store={store}>
          <LoginForm />
        </Provider>
    );
    const submitButton = getByText('Zaloguj');

    await act(async () => {
      fireEvent.click(submitButton);
    });

    expect(toast.error).toHaveBeenCalledWith('Błąd logowania. Wymagane jest podanie adresu email i hasła.');
  });

  it('shows an error when the email is invalid', async () => {
    checkEmail.mockResolvedValue(false);
    const {getByLabelText, getByText} = render(
        <Provider store={store}>
          <LoginForm />
        </Provider>
    );
    const emailInput = getByLabelText('Email');
    const passwordInput = getByLabelText('Hasło');
    const submitButton = getByText('Zaloguj');

    fireEvent.change(emailInput, {target: {value: TEST_BAD_EMAIL}});
    fireEvent.change(passwordInput, {target: {value: TEST_PASSWORD}});

    await act(async () => {
      fireEvent.click(submitButton);
    });

    expect(toast.error).toHaveBeenCalledWith('Błąd logowania. Nieprawidłowy adres email.');
  });

  it('shows an error when the login request fails', async () => {
    checkEmail.mockResolvedValue(true);
    axios.post.mockRejectedValue(new Error());

    const {getByLabelText, getByText} = render(
        <Provider store={store}>
          <LoginForm />
        </Provider>
    );
    const emailInput = getByLabelText('Email');
    const passwordInput = getByLabelText('Hasło');
    const submitButton = getByText('Zaloguj');

    fireEvent.change(emailInput, {target: {value: TEST_EMAIL}});
    fireEvent.change(passwordInput, {target: {value: TEST_PASSWORD}});

    await act(async () => {
      fireEvent.click(submitButton);
    });

    expect(toast.error).toHaveBeenCalledWith('Błąd logowania. Spróbuj ponownie.');
  });
});
