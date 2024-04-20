'use client'

import React, {useState} from 'react';
import {CSSTransition, TransitionGroup} from 'react-transition-group';
import LoginForm from '../components/LoginForm/LoginForm';
import RegisterForm from '../components/RegisterForm/RegisterForm';
import './page.css';

export default function Login() {
    const [isLoginFormVisible, setLoginFormVisibility] = useState(true)

    return (
        <div className="flex h-screen">
            <div className="hidden lg:flex items-center justify-center flex-1 bg-white text-black">
                <div className="max-w-md text-center">
                    some pretty image or vector art related to voting
                </div>
            </div>
            <div className="w-full bg-gray-100 lg:w-1/2 flex items-center justify-center">
                <div className="max-w-md w-full p-6">
                    <TransitionGroup>
                        <CSSTransition
                            key={isLoginFormVisible ? 'LoginForm' : 'RegisterForm'}
                            timeout={500}
                            classNames="fade"
                            unmountOnExit
                        >
                            {isLoginFormVisible ? <LoginForm/> : <RegisterForm/>}
                        </CSSTransition>
                    </TransitionGroup>
                    <div className="mt-4 text-sm text-gray-600 text-center hover:underline">
                        <button className='changeFormButton'
                                onClick={() => setLoginFormVisibility(!isLoginFormVisible)}>
                            Switch to {isLoginFormVisible ? 'Register' : 'Login'}
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
}

