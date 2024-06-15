import React from "react";

export default function LabeledSelect({
                                          label,
                                          register,
                                          name,
                                          options,
                                          error,
                                          title
                                      }) {
    return (
        <div className='relative'>
            <label title={title} htmlFor={name} className='block uppercase text-xs font-bold mb-2'>{label}</label>
            <select
                className={`border-0 px-3 py-3 bg-white rounded text-sm shadow focus:outline-none focus:border-gray-200 focus:ring-gray-300 focus:ring w-full ease-linear transition-all duration-150 ${
                    error ? 'border-red-500 border' : ''
                }`}
                {...register(name)}
                id={name}
                title={title}
            >
                {options.map((option) => (
                    <option key={option.value} value={option.value}>{option.label}</option>
                ))}
            </select>
            {error && (
                <p className='absolute right-2 top-0 mt-1 text-xs text-red-500'>{`${error.message}`}</p>
            )}
        </div>
    );
}
