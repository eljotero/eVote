import React from 'react';
import {fireEvent, render} from '@testing-library/react';
import '@testing-library/jest-dom';
import RegisterForm from '@/app/components/RegisterForm/RegisterForm';
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
        success: jest.fn()
    },
}));

const TEST_EMAIL = 'test@example.com';
const TEST_PASSWORD = 'password123';
const TEST_BAD_EMAIL = 'testexamplecom';
const TEST_BAD_PASSWORD = 'password456';
const TEST_SHORT_PASSWORD = 'pass';

describe('RegisterForm', () => {
    afterEach(() => {
        jest.clearAllMocks();
    });

    it('renders RegisterForm and checks if input fields and button are present', () => {
        const {getByLabelText, getByText} = render(<RegisterForm/>);

        const emailInput = getByLabelText('Email');
        const passwordInput = getByLabelText('Hasło');
        const submitButton = getByText('Zarejestruj');

        expect(emailInput).toBeInTheDocument();
        expect(passwordInput).toBeInTheDocument();
        expect(submitButton).toBeInTheDocument();
    });

    it('checks if input fields are working correctly', () => {
        const {getByLabelText} = render(<RegisterForm/>);

        const emailInput = getByLabelText('Email');
        const passwordInput = getByLabelText('Hasło');

        fireEvent.change(emailInput, {target: {value: TEST_EMAIL}});
        fireEvent.change(passwordInput, {target: {value: TEST_PASSWORD}});

        expect(emailInput.value).toBe(TEST_EMAIL);
        expect(passwordInput.value).toBe(TEST_PASSWORD);
    });

    it('calls handleSubmit when the form is submitted', async () => {
        checkEmail.mockResolvedValue(true);
        axios.post.mockResolvedValue({ status: 200 });

        const {getByLabelText, getByText} = render(<RegisterForm/>);

        const emailInput = getByLabelText('Email');
        const passwordInput = getByLabelText('Hasło');
        const confirmPasswordInput = getByLabelText('Potwierdź hasło');
        const submitButton = getByText('Zarejestruj');

        fireEvent.change(emailInput, {target: {value: TEST_EMAIL}});
        fireEvent.change(passwordInput, {target: {value: TEST_PASSWORD}});
        fireEvent.change(confirmPasswordInput, {target: {value: TEST_PASSWORD}});

        await act(async () => {
            fireEvent.click(submitButton);
        });

        expect(axios.post).toHaveBeenCalledWith('/auth/register', {
            email: TEST_EMAIL,
            password: TEST_PASSWORD,
        });
        expect(toast.success).toHaveBeenCalledWith('Konto zostało utworzone. Zaloguj się.');
    });

    it('shows an error when the email, password, or confirmPassword is empty', async () => {
        const {getByText} = render(<RegisterForm/>);
        const submitButton = getByText('Zarejestruj');

        await act(async () => {
            fireEvent.click(submitButton);
        });

        expect(toast.error).toHaveBeenCalledWith('Nie można zarejestrować konta. Wymagane jest podanie adresu email i hasła.');
    });

    it('shows an error when the password and confirmPassword do not match', async () => {
        const {getByLabelText, getByText} = render(<RegisterForm/>);

        const emailInput = getByLabelText('Email');
        const passwordInput = getByLabelText('Hasło');
        const confirmPasswordInput = getByLabelText('Potwierdź hasło');
        const submitButton = getByText('Zarejestruj');

        fireEvent.change(emailInput, {target: {value: TEST_EMAIL}});
        fireEvent.change(passwordInput, {target: {value: TEST_PASSWORD}});
        fireEvent.change(confirmPasswordInput, {target: {value: TEST_BAD_PASSWORD}});

        await act(async () => {
            fireEvent.click(submitButton);
        });

        expect(toast.error).toHaveBeenCalledWith('Nie można zarejestrować konta. Hasła nie pasują do siebie.');
    });

    it('shows an error when the password is less than 8 characters', async () => {
        const {getByLabelText, getByText} = render(<RegisterForm/>);

        const emailInput = getByLabelText('Email');
        const passwordInput = getByLabelText('Hasło');
        const confirmPasswordInput = getByLabelText('Potwierdź hasło');
        const submitButton = getByText('Zarejestruj');

        fireEvent.change(emailInput, {target: {value: TEST_EMAIL}});
        fireEvent.change(passwordInput, {target: {value: TEST_SHORT_PASSWORD}});
        fireEvent.change(confirmPasswordInput, {target: {value: TEST_SHORT_PASSWORD}});

        await act(async () => {
            fireEvent.click(submitButton);
        });

        expect(toast.error).toHaveBeenCalledWith('Nie można zarejestrować konta. Hasło musi mieć co najmniej 8 znaków.');
    });

    it('shows an error when the email is invalid', async () => {
        checkEmail.mockResolvedValue(false);
        const {getByLabelText, getByText} = render(<RegisterForm/>);

        const emailInput = getByLabelText('Email');
        const passwordInput = getByLabelText('Hasło');
        const confirmPasswordInput = getByLabelText('Potwierdź hasło');
        const submitButton = getByText('Zarejestruj');

        fireEvent.change(emailInput, {target: {value: TEST_BAD_EMAIL}});
        fireEvent.change(passwordInput, {target: {value: TEST_PASSWORD}});
        fireEvent.change(confirmPasswordInput, {target: {value: TEST_PASSWORD}});

        await act(async () => {
            fireEvent.click(submitButton);
        });

        expect(toast.error).toHaveBeenCalledWith('Nie można zarejestrować konta. Nieprawidłowy adres email.');
    });

    it('shows an error when the email already exists', async () => {
        checkEmail.mockResolvedValue(true);
        axios.post.mockRejectedValue(new Error());
        const {getByLabelText, getByText} = render(<RegisterForm/>);

        const emailInput = getByLabelText('Email');
        const passwordInput = getByLabelText('Hasło');
        const confirmPasswordInput = getByLabelText('Potwierdź hasło');
        const submitButton = getByText('Zarejestruj');

        fireEvent.change(emailInput, {target: {value: TEST_EMAIL}});
        fireEvent.change(passwordInput, {target: {value: TEST_PASSWORD}});
        fireEvent.change(confirmPasswordInput, {target: {value: TEST_PASSWORD}});

        await act(async () => {
            fireEvent.click(submitButton);
        });

        expect(toast.error).toHaveBeenCalledWith('Konto z takim adresem email już istnieje. Zaloguj się.');
    });
});
