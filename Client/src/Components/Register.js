import backgroundImage from '../../src/Components/images/login.jpg';
import './Register.css';
import axios from 'axios';
import React, { useState } from 'react';

function Register() {
  async function onSubmit(event) {
    try {
      event.preventDefault();

      // confirm password
      if (user.cPassword !== user.password) {
        alert('Passwords are not matched');
        return;
      }

      const data = user;
      const response = await axios.post('http://localhost:8081/api/user', data);
      console.log(response);
      if (response.status === 201 || response.status === 200) setUser(initUser);
    } catch (error) {
      console.error(error);
    }
  }

  const initUser = {
    fname: '',
    lname: '',
    password: '',
    cPassword: '',
    email: '',
    status: 1,
  };
  const [user, setUser] = useState(initUser);

  return (
    <>
      <div className='main-wrapper'>
        <img src={backgroundImage} className='background-image' />
        <form
          onSubmit={onSubmit}
          className='container outer-wrapper'
          method='POST'
        >
          <h3>Sign In - Customer</h3>
          <div className='mb-3'>
            <label>Email address</label>
            <input
              type='email'
              className='form-control'
              placeholder='Enter email'
              name='email'
              required
              value={user.email}
              onChange={(e) => setUser({ ...user, email: e.target.value })}
            />
          </div>
          <div className='mb-3'>
            <label>Password</label>
            <input
              type='password'
              className='form-control'
              placeholder='Enter password'
              name='password'
              required
              value={user.password}
              onChange={(e) => setUser({ ...user, password: e.target.value })}
            />
          </div>
          <div className='mb-3'>
            <label>Confirm Password</label>
            <input
              type='password'
              className='form-control'
              placeholder='Enter password'
              name='cPassword'
              required
              value={user.cPassword}
              onChange={(e) => setUser({ ...user, cPassword: e.target.value })}
            />
          </div>
          <div className='mb-3'>
            <label>First name</label>
            <input
              type='text'
              className='form-control'
              placeholder='Enter first name'
              name='fname'
              required
              value={user.fname}
              onChange={(e) => setUser({ ...user, fname: e.target.value })}
            />
          </div>
          <div className='mb-3'>
            <label>Last name</label>
            <input
              type='text'
              className='form-control'
              placeholder='Enter last name'
              name='lname'
              required
              value={user.lname}
              onChange={(e) => setUser({ ...user, lname: e.target.value })}
            />
          </div>
          <div className='d-grid'>
            <button type='submit' className='btn btn-primary'>
              Register
            </button>
          </div>
        </form>
      </div>
    </>
  );
}
export default Register;
