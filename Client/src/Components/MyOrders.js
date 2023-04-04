import React, { useEffect, useState } from 'react';
import Header from './Header';
import Content from './Content';
import BodySection from './BodySection';
import Footer from './Footer';
import Cookies from 'js-cookie';
import axios from 'axios';
import './MyOrders.css';

export default function MyOrders(props) {
  const { bag, bagCount } = props;

  const [user, setUser] = useState({});
  const [orders, setOrders] = useState([]);

  async function getOrders(userRoleId) {
    try {
      const url =
        userRoleId === 1
          ? `http://localhost:8081/api/order/getOrdersByUserId/${user.id}`
          : `http://localhost:8081/api/order/getOrdersByVendorId/${user.id}`;
      const response = await axios.get(url);
      if (response.status === 200) {
        setOrders(response.data);
      }
    } catch (error) {}
  }

  useEffect(() => {
    const authUser = Cookies.get('auth-user');
    if (authUser) {
      setUser(JSON.parse(authUser));
    }
  }, []);

  useEffect(async () => {
    if (user && user.id) {
      await getOrders(user.user_role_id);
    }
  }, [user]);

  function renderUserWise() {
    if (user && Number(user.user_role_id) === 1) {
      return (
        <>
          <h1>Hello {user.fname}</h1>
          <h3>Here are your payments details</h3>
        </>
      );
    } else {
      return (
        <>
          <h1>Hello Vendor</h1>
          <h3>Here are sold product details</h3>
        </>
      );
    }
  }

  return (
    <div>
      <Header bag={bag} bagCount={bagCount} />
      {renderUserWise()}
      <div className='orders-wrapper'>
        {orders ? (
          orders.map((o) => {
            return (
              <div key={o.id} className='card' style={{ width: '25rem' }}>
                <img
                  className='card-img-top'
                  src='https://img.freepik.com/free-psd/product-display-3d-podium-background_47987-11260.jpg?w=826&t=st=1680643759~exp=1680644359~hmac=ee1286d0c5bb2ffbcbe9707ebe305aed849d7032073ae27d75fd73e7fb4753f7'
                  alt='Card image cap'
                />
                <div className='card-body'>
                  <h5 className='card-title'>{o.product_title}</h5>
                  <p className='card-text'>{o.product_desc}</p>
                  {/* <a href='#' className='btn btn-primary'>
                        Go somewhere
                      </a> */}
                  <br />
                  <div className='installments'>
                    {o.order_details_list.map((i, idx) => {
                      return (
                        <p>
                          installment {idx + 1} - {i.dueDate} -{' '}
                          {i.paiedDate
                            ? 'Paid at: ' + i.paiedDate
                            : 'Not paid yet'}
                        </p>
                      );
                    })}
                  </div>
                </div>
              </div>
            );
          })
        ) : (
          <h3>No orders yet</h3>
        )}
      </div>
      <Footer />
    </div>
  );
}
