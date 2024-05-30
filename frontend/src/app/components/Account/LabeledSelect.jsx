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
        <div>
            <label title={title}
                   htmlFor={name}>{label}</label>
            <select
                className='block w-5/6 rounded-md h-1/2 mr-2' {...register(name)}
                id={name}>
                {options.map((option) => (
                    <option key={option.value}
                            value={option.value}>{option.label}</option>
                ))}
            </select>
            {error && (
                <p className='text-red-500'>{`${error.message}`}</p>
            )}
        </div>
    );
}
