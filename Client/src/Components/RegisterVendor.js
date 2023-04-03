import backgroundImage from '../../src/Components/images/login.jpg';
import './Register.css';
import axios from 'axios';
import React, { useState } from 'react';

function RegisterVendor() {
  async function onSubmit(event) {
    try {
      event.preventDefault();

      // confirm password
      if (user.cPassword !== user.password) {
        alert('Passwords are not matched');
        return;
      }

      const data = user;
      const response = await axios.post(
        'http://localhost:8081/api/vendor',
        data
      );
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
    vendor_name: '',
    address: '',
    contact: '',
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
          <h3>Sign In - Vendor</h3>
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
          <div className='mb-3'>
            <label>Vendor Name</label>
            <input
              type='text'
              className='form-control'
              placeholder='Enter vendor name'
              name='vendor_name'
              required
              value={user.vendor_name}
              onChange={(e) =>
                setUser({ ...user, vendor_name: e.target.value })
              }
            />
          </div>
          <div className='mb-3'>
            <label>Address</label>
            <input
              type='text'
              className='form-control'
              placeholder='Enter address'
              name='address'
              required
              value={user.address}
              onChange={(e) => setUser({ ...user, address: e.target.value })}
            />
          </div>
          <div className='mb-3'>
            <label>Contact</label>
            <input
              type='number'
              className='form-control'
              placeholder='Contact'
              name='contact'
              required
              value={user.contact}
              onChange={(e) => setUser({ ...user, contact: e.target.value })}
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
export default RegisterVendor;
