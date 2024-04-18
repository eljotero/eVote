'use client'

import React, { useState } from 'react'
import { CSSTransition, TransitionGroup } from 'react-transition-group'
import LoginForm from '../components/LoginForm/LoginForm'
import RegisterForm from '../components/RegisterForm/RegisterForm'
import './page.css'

const Login = () => {
  const [isLoginFormVisible, setLoginFormVisibility] = useState(true)

  return (
    <div className="formContainer">
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
      <button className='changeFormButton' onClick={() => setLoginFormVisibility(!isLoginFormVisible)}>
        Switch to {isLoginFormVisible ? 'Register' : 'Login'}
      </button>
    </div>
  )
}

export default Login