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
        const submitButton = getByText('Zarejestruj się');

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
        axios.post.mockResolvedValue({ status: 201 });

        const {getByLabelText, getByText} = render(<RegisterForm/>);

        const emailInput = getByLabelText('Email');
        const passwordInput = getByLabelText('Hasło');
        const confirmPasswordInput = getByLabelText('Potwierdź hasło');
        const submitButton = getByText('Zarejestruj się');

        fireEvent.change(emailInput, {target: {value: TEST_EMAIL}});
        fireEvent.change(passwordInput, {target: {value: TEST_PASSWORD}});
        fireEvent.change(confirmPasswordInput, {target: {value: TEST_PASSWORD}});

        await act(async () => {
            fireEvent.click(submitButton);
        });

        expect(axios.post).toHaveBeenCalledWith('https://localhost:8080/api/auth/register', {
            email: TEST_EMAIL,
            password: TEST_PASSWORD,
        });
        expect(toast.success).toHaveBeenCalledWith('Konto zostało utworzone. Zaloguj się.');
    });

    it('shows an error when the email already exists', async () => {
        checkEmail.mockResolvedValue(true);
        axios.post.mockRejectedValue(new Error());
        const {getByLabelText, getByText} = render(<RegisterForm/>);

        const emailInput = getByLabelText('Email');
        const passwordInput = getByLabelText('Hasło');
        const confirmPasswordInput = getByLabelText('Potwierdź hasło');
        const submitButton = getByText('Zarejestruj się');

        fireEvent.change(emailInput, {target: {value: TEST_EMAIL}});
        fireEvent.change(passwordInput, {target: {value: TEST_PASSWORD}});
        fireEvent.change(confirmPasswordInput, {target: {value: TEST_PASSWORD}});

        await act(async () => {
            fireEvent.click(submitButton);
        });

        expect(toast.error).toHaveBeenCalledWith('Konto z takim adresem email już istnieje. Zaloguj się.');
    });
});
