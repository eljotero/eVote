import React from 'react';

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
        <div>
            <label htmlFor={name}>{label}</label>
            <input {...register(name)} type={type}
                   className='block w-5/6 rounded-md h-1/2'
                   disabled={disabled}
                   placeholder={placeholder}
            id={name}/>
            {error && (
                <p className='text-red-500'>{`${error.message}`}</p>
            )}
        </div>
    );
}
