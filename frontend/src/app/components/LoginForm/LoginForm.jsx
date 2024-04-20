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
        <>
            <h1 className="text-3xl font-semibold mb-6 text-black text-center">Login</h1>
            <h1 className="text-sm font-semibold mb-6 text-gray-500 text-center">Some text again?</h1>
            <form action="#" method="POST" className="space-y-4">
                <div>
                    <label htmlFor="email" className="block text-sm font-medium text-gray-700">Email</label>
                    <input type="text" id="email" name="email" value={email} onChange={(e) => setEmail(e.target.value)}
                           className="mt-1 p-2 w-full border rounded-md focus:border-gray-200 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-300 transition-colors duration-300"/>
                </div>
                <div>
                    <label htmlFor="password" className="block text-sm font-medium text-gray-700">Password</label>
                    <input type="password" id="password" name="password" value={password}
                           onChange={(e) => setPassword(e.target.value)}
                           className="mt-1 p-2 w-full border rounded-md focus:border-gray-200 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-300 transition-colors duration-300"/>
                </div>
                <div>
                    <button type="submit"
                            className="w-full bg-black text-white p-2 rounded-md hover:bg-gray-800 focus:bg-black focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-900 transition-colors duration-300">
                        Login
                    </button>
                </div>
            </form>
        </>
    )
}
