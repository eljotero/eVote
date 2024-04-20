import React, {useState} from 'react';
import './RegisterForm.css';
import {checkEmail} from "@/app/services/emailService";

export default function RegisterForm() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        const isEmailValid = checkEmail(email);
        if (!isEmailValid) {
            console.log('Email is not valid');
        }
    }

    return (
        <div className='registerFormContainer'>
            <div className='registerForm'>
                <h1>Register</h1>
                <form onSubmit={handleSubmit}>
                    <input type='text' placeholder='Name'/>
                    <input
                        type='email'
                        placeholder='Email'
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <input
                        type='password'
                        placeholder='Password'
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    <button type='submit'>Register</button>
                </form>
            </div>
        </div>
    );
}
