import React from 'react';
import { render, fireEvent } from '@testing-library/react';
import LabeledInput from "@/app/components/Account/LabeledInput";

describe('LabeledInput', () => {
    it('adds error class when error prop is true', () => {
        const mockRegister = jest.fn();
        const { getByLabelText } = render(
            <LabeledInput
                label="Test Label"
                register={mockRegister}
                name="testName"
                type="text"
                error={{ message: 'Test error message' }}
                disabled={false}
                placeholder="Test placeholder"
            />
        );

        const inputElement = getByLabelText('Test Label');
        expect(inputElement).toHaveClass('border', 'border-red-500');
    });

    it('does not add error class when error prop is false', () => {
        const mockRegister = jest.fn();
        const { getByLabelText } = render(
            <LabeledInput
                label="Test Label"
                register={mockRegister}
                name="testName"
                type="text"
                error={null}
                disabled={false}
                placeholder="Test placeholder"
            />
        );

        const inputElement = getByLabelText('Test Label');
        expect(inputElement).not.toHaveClass('border', 'border-red-500');
    });
});
