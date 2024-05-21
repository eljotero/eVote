import React from 'react';

const LabeledInput = ({ label, value, onChange, placeholder, type }) => (
  <h1>
    {label}{' '}
    <input
      value={value}
      onChange={onChange}
      className='block w-5/6 rounded-md h-1/2'
      placeholder={placeholder}
      type={type}
    />
  </h1>
);

export default LabeledInput;
