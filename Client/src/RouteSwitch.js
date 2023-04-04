import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './Components/Home';
import Comingsoon from './Components/Comingsoon';
import Products from './Components/Products';
import Bag from './Components/Bag';
import { useState } from 'react';
import Login from './Components/Login';
import Register from './Components/Register';
import RegisterVendor from './Components/RegisterVendor';
import MyOrders from './Components/MyOrders';

const RouteSwitch = () => {
  const [bag, setBag] = useState([]);
  function addToBag(product) {
    const alreadyInBag = bag.find((item) => item.id === product.id);
    alreadyInBag
      ? setBag(
          bag.map((item) =>
            item.id === product.id
              ? { ...alreadyInBag, qty: alreadyInBag.qty + 1 }
              : item
          )
        )
      : setBag([...bag, { ...product, qty: 1 }]);
  }

  function removeFromBag(product) {
    const itemToRemove = bag.find((item) => item.id === product.id);
    itemToRemove.qty === 1
      ? setBag(bag.filter((item) => item.id !== product.id))
      : setBag(
          bag.map((item) =>
            item.id === product.id ? { ...product, qty: product.qty - 1 } : item
          )
        );
  }

  function removeEntireItem(product) {
    return setBag(bag.filter((item) => item.id !== product.id));
  }

  const bagCount = bag.reduce((count, item) => count + item.qty, 0);

  return (
    <BrowserRouter basename='/'>
      <Routes>
        <Route path='/' element={<Home bag={bag} bagCount={bagCount} />} />
        <Route
          path='/bracelets'
          element={
            <Products
              category='bracelets'
              addToBag={addToBag}
              bag={bag}
              bagCount={bagCount}
            />
          }
        />
        <Route
          path='/earrings'
          element={
            <Products
              category='earrings'
              addToBag={addToBag}
              bag={bag}
              bagCount={bagCount}
            />
          }
        />
        <Route
          path='/necklaces'
          element={
            <Products
              category='necklaces'
              addToBag={addToBag}
              bag={bag}
              bagCount={bagCount}
            />
          }
        />
        <Route
          path='/comingsoon'
          element={<Comingsoon bag={bag} bagCount={bagCount} />}
        />
        <Route
          path='/all'
          element={
            <Products
              category='all'
              addToBag={addToBag}
              bag={bag}
              bagCount={bagCount}
            />
          }
        />
        <Route
          path='/bag'
          element={
            <Bag
              addToBag={addToBag}
              removeFromBag={removeFromBag}
              removeEntireItem={removeEntireItem}
              bag={bag}
              bagCount={bagCount}
            />
          }
        />
        <Route path='/login' element={<Login />} />
        <Route path='/register' element={<Register />} />
        <Route path='/register-vendor' element={<RegisterVendor />} />
        <Route
          path='/my-orders'
          element={<MyOrders bag={bag} bagCount={bagCount} />}
        />
      </Routes>
    </BrowserRouter>
  );
};

export default RouteSwitch;
