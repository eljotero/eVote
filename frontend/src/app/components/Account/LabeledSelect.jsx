export default function LabeledSelect({ label, value, onChange, options }) {
  return (
    <h1>
      {label}{' '}
      <select
        value={value}
        onChange={onChange}
        className='block w-5/6 rounded-md h-1/2 mr-2'
      >
        {options.map((option) => (
          <option key={option.value} value={option.value}>
            {option.label}
          </option>
        ))}
      </select>
    </h1>
  );
}
