import Header from "./Header";
import Footer from "./Footer";
import Product from "./Product";
import { data } from "./data.js";
import { Link } from "react-router-dom";

function Products(props) {
  const { category, bag, addToBag, bagCount } = props;

  return (
    <div>
      <Header bag={bag} bagCount={bagCount} />
      <div className="navbar">
        <Link to="/all">
          <li className={category === "all" ? "active" : null}>All</li>
        </Link>
        <Link to="/bracelets">
          <li className={category === "bracelets" ? "active" : null}>
            Mobile Phones
          </li>
        </Link>
        <Link to="/earrings">
          <li className={category === "earrings" ? "active" : null}>Laptops</li>
        </Link>
        <Link to="/necklaces">
          <li className={category === "necklaces" ? "active" : null}>
            Smart Watches
          </li>
        </Link>
      </div>
      {category === "bracelets" ? (
        <div className="prod container">
          <Product category={data.bracelets} addToBag={addToBag} />
        </div>
      ) : category === "earrings" ? (
        <div className="prod container">
          <Product category={data.earrings} addToBag={addToBag} />
        </div>
      ) : category === "necklaces" ? (
        <div className="prod container">
          <Product category={data.necklaces} addToBag={addToBag} />
        </div>
      ) : category === "all" ? (
        <div className="prod container">
          <Product category={data.earrings} addToBag={addToBag} />
          <Product category={data.bracelets} addToBag={addToBag} />
          <Product category={data.necklaces} addToBag={addToBag} />
        </div>
      ) : null}
      <Footer />
    </div>
  );
}

export default Products;
