import React from 'react';
import { render, fireEvent } from '@testing-library/react';
import LabeledInput from '../src/app/components/Account/LabeledInput';

describe('LabeledInput', () => {
  it('renders correctly', () => {
    const { getByPlaceholderText } = render(
      <LabeledInput label='Test Label' placeholder='Test Placeholder' />
    );

    expect(getByPlaceholderText('Test Placeholder')).toBeInTheDocument();
  });

  it('updates on change', () => {
    const onChange = jest.fn();
    const { getByPlaceholderText } = render(
      <LabeledInput
        label='Test Label'
        placeholder='Test Placeholder'
        onChange={onChange}
      />
    );

    fireEvent.change(getByPlaceholderText('Test Placeholder'), {
      target: { value: 'New Value' },
    });

    expect(onChange).toHaveBeenCalled();
  });
});
