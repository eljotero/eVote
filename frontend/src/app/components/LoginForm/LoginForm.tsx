import React from 'react'
import './LoginForm.css'

const LoginForm = () => {
  return (
    <div className='loginFormContainer'>
        <div className='loginForm'>
            <h1>Login</h1>
            <form>
            <input type='email' placeholder='Email'/>
            <input type='password' placeholder='Password'/>
            <button>Login</button>
            </form>
        </div>
    </div>
  )
}

export default LoginForm