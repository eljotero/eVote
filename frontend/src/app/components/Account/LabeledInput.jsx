import React from 'react';
import '../input.css';

export default function LabeledInput({
                                         label,
                                         register,
                                         name,
                                         type,
                                         error,
                                         disabled,
                                         placeholder
                                     }) {
    return (
        <div className='relative'>
            <label htmlFor={name} className="block uppercase text-xs font-bold mb-2">{label}</label>
            <input {...register(name)} type={type}
                   className={`className="border-0 px-3 py-3 bg-white rounded text-sm shadow focus:outline-none focus:border-gray-200 focus:ring-gray-300 focus:ring w-full ease-linear transition-all duration-150 ${
                       error ? 'border border-red-500' : ''
                   }`}
                   disabled={disabled}
                   placeholder={placeholder}
            id={name}/>
            {error && (
                <span className='absolute right-2 top-0 mt-1 text-xs text-red-500'>{`${error.message}`}</span>
            )}
        </div>
    );
}
