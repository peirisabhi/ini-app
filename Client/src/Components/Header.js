import React from 'react';
import './Header.css';
import logo from './images/logo.png';
import { BsBag } from 'react-icons/bs';
import { Link } from 'react-router-dom';

function Header(props) {
  const { bagCount } = props;
  return (
    <div className='header'>
      <div className='header-left'>
        <div className='header-text'>
          <Link className='login_text' to='/login'>
            Login
          </Link>
          <Link className='Signup_text' to='/register'>
            SignUp
          </Link>
        </div>
      </div>
      <Link to='/'>
        <img src={logo} className='logo' alt='logo' />
      </Link>
      <div className='header-right'>
        <Link to='/all'>
          <div className='ShopBtn'>SHOP</div>
        </Link>
        <Link to='/bag'>
          <div>
            <BsBag />
          </div>
        </Link>
        <div>{bagCount !== 0 ? bagCount : null}</div>
      </div>
    </div>
  );
}

export default Header;
