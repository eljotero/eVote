import React from 'react';
import {fireEvent, getByText, render} from '@testing-library/react';
import '@testing-library/jest-dom';
import LoginForm from "@/app/components/LoginForm/LoginForm";

describe('LoginForm', () => {
    it('renders LoginForm and checks if input fields and button are present', () => {
        const { getByLabelText, getByText } = render(<LoginForm />);

        const emailInput = getByLabelText('Email');
        const passwordInput = getByLabelText('Password');
        const submitButton = getByText('Login');

        expect(emailInput).toBeInTheDocument();
        expect(passwordInput).toBeInTheDocument();
        expect(submitButton).toBeInTheDocument();
    });

    it('checks if input fields are working correctly', () => {
        const { getByLabelText } = render(<LoginForm />);

        const emailInput = getByLabelText('Email');
        const passwordInput = getByLabelText('Password');

        fireEvent.change(emailInput, { target: { value: 'test@example.com' } });
        fireEvent.change(passwordInput, { target: { value: 'password123' } });

        expect(emailInput.value).toBe('test@example.com');
        expect(passwordInput.value).toBe('password123');
    });
});
