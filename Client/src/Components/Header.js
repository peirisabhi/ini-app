import './Header.css';
import logo from './images/logo.png';
import { BsBag } from 'react-icons/bs';
import { Link } from 'react-router-dom';
import React, { useState, useEffect } from 'react';
import Cookies from 'js-cookie';
import { useNavigate } from 'react-router-dom';
function Header(props) {
  const { bagCount } = props;
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [user, setUser] = useState({});
  let navigate = useNavigate();

  useEffect(() => {
    const authUser = Cookies.get('auth-user');
    if (authUser) {
      setIsLoggedIn(true);
      setUser(JSON.parse(authUser));
    }
  }, []);

  function logOut() {
    Cookies.remove('auth-user');
    navigate('/login');
  }

  return (
    <div className='header'>
      <div className='header-left'>
        <div className='header-text'>
          {isLoggedIn ? (
            <>
              <b>Welcome {user.fname}</b>
              <Link className='login_text' to='/my-orders'>
                My Orders
              </Link>
              <a href='#' className='login_text' onClick={logOut}>
                Logout
              </a>
            </>
          ) : (
            <>
              <Link className='login_text' to='/login'>
                Login
              </Link>
              <Link className='Signup_text' to='/register'>
                SignUp
              </Link>
            </>
          )}
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
