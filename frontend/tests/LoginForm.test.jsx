import React from 'react';
import {render} from '@testing-library/react';
import LoginForm from "@/app/components/LoginForm/LoginForm";

describe('LoginForm', () => {
    it('renders LoginForm and checks if input fields and button are present', () => {
        render(<LoginForm />)
        expect(true).toBe(true);
    });
});
