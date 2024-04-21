import React from 'react';
import {fireEvent, render} from '@testing-library/react';
import '@testing-library/jest-dom';
import RegisterForm from "@/app/components/RegisterForm/RegisterForm";

describe('RegisterForm', () => {
    it('renders RegisterForm and checks if input fields and button are present', () => {
        const { getByLabelText, getByText } = render(<RegisterForm />);

        const usernameInput = getByLabelText('Username');
        const emailInput = getByLabelText('Email');
        const passwordInput = getByLabelText('Password');
        const submitButton = getByText('Register');

        expect(usernameInput).toBeInTheDocument();
        expect(emailInput).toBeInTheDocument();
        expect(passwordInput).toBeInTheDocument();
        expect(submitButton).toBeInTheDocument();
    });

    it('checks if input fields are working correctly', () => {
        const { getByLabelText } = render(<RegisterForm />);

        const usernameInput = getByLabelText('Username');
        const emailInput = getByLabelText('Email');
        const passwordInput = getByLabelText('Password');

        fireEvent.change(usernameInput, { target: { value: 'testuser' } });
        fireEvent.change(emailInput, { target: { value: 'test@example.com' } });
        fireEvent.change(passwordInput, { target: { value: 'password123' } });

        expect(usernameInput.value).toBe('testuser');
        expect(emailInput.value).toBe('test@example.com');
        expect(passwordInput.value).toBe('password123');
    });
});