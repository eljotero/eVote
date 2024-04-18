import React from 'react'
import './RegisterForm.css'

const RegisterForm = () => {
  return (
    <div className='registerFormContainer'>
        <div className='registerForm'>
            <h1>Register</h1>
            <form>
            <input type='text' placeholder='Name'/>
            <input type='email' placeholder='Email'/>
            <input type='password' placeholder='Password'/>
            <button>Register</button>
            </form>
        </div>
    </div>
  )
}

export default RegisterForm