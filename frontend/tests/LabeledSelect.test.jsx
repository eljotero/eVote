import React from 'react';
import { render, fireEvent } from '@testing-library/react';
import LabeledSelect from "@/app/components/Account/LabeledSelect";

describe('LabeledSelect', () => {
    const options = [
        { label: 'Option 1', value: 'option1' },
        { label: 'Option 2', value: 'option2' },
        { label: 'Option 3', value: 'option3' },
    ];

    it('adds error class when error prop is true', () => {
        const mockRegister = jest.fn();
        const { getByLabelText } = render(
            <LabeledSelect
                label="Test Label"
                register={mockRegister}
                name="testName"
                options={options}
                error={{ message: 'Test error message' }}
                title="Test Title"
            />
        );

        const selectElement = getByLabelText('Test Label');
        expect(selectElement).toHaveClass('border', 'border-red-500');
    });

    it('does not add error class when error prop is false', () => {
        const mockRegister = jest.fn();
        const { getByLabelText } = render(
            <LabeledSelect
                label="Test Label"
                register={mockRegister}
                name="testName"
                options={options}
                error={null}
                title="Test Title"
            />
        );

        const selectElement = getByLabelText('Test Label');
        expect(selectElement).not.toHaveClass('border', 'border-red-500');
    });
});
