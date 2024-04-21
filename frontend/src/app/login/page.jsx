'use client'

import React, {useState} from 'react';
import {CSSTransition, TransitionGroup} from 'react-transition-group';
import LoginForm from '../components/LoginForm/LoginForm';
import RegisterForm from '../components/RegisterForm/RegisterForm';
import Image from 'next/image';
import './page.css';

export default function Login() {
    const [isLoginFormVisible, setLoginFormVisibility] = useState(true)

    return (
        <section className="flex h-screen">
            <div className="hidden lg:flex items-center justify-center flex-1 bg-white text-black">
                <div className="max-w-md text-center">
                    <Image
                        src="/evote.png"
                        alt="Evote"
                        width={500}
                        height={300}
                    />
                </div>
            </div>
            <div className="w-full bg-gray-100 lg:w-1/2 flex justify-center items-center">
                <div className="max-w-md w-full">
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
                    <div className="mt-96 text-sm text-gray-600 text-center">
                        <button className='mt-20 changeFormButton hover:underline'
                                onClick={() => setLoginFormVisibility(!isLoginFormVisible)}>
                            Switch to {isLoginFormVisible ? 'Register' : 'Login'}
                        </button>
                    </div>
                </div>
            </div>
        </section>
    );
}

