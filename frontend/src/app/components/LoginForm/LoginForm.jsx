import React, {useState} from 'react';
import {checkEmail} from "@/app/services/emailService";
import './LoginForm.css';

export default function LoginForm() {
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
        <div className='loginFormContainer'>
            <div className='loginForm'>
                <h1>Login</h1>
                <form onSubmit={handleSubmit}>
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
                    <button type='submit'>Login</button>
                </form>
            </div>
        </div>
    )
}
