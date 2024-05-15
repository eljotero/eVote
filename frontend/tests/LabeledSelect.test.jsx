import { fireEvent, render } from '@testing-library/react';
import LabeledSelect from '../src/app/components/Account/LabeledSelect';

describe('LabeledSelect', () => {
  const options = [
    { value: 'value1', label: 'Label 1' },
    { value: 'value2', label: 'Label 2' },
  ];

  it('renders correctly', () => {
    const { getByText } = render(
      <LabeledSelect label='Test Label' options={options} />
    );

    expect(getByText('Test Label')).toBeInTheDocument();
    expect(getByText('Label 1')).toBeInTheDocument();
    expect(getByText('Label 2')).toBeInTheDocument();
  });

  it('updates on change', () => {
    const onChange = jest.fn();
    const { getByText, container } = render(
      <LabeledSelect label='Test Label' options={options} onChange={onChange} />
    );

    const select = container.querySelector('select');
    fireEvent.change(select, { target: { value: 'value2' } });

    expect(onChange).toHaveBeenCalled();
  });
});
