function Product(props) {
  const { category, addToBag } = props;

  return (
    <div className="product">
      {category.map((item) => (
        <div className="prod cell" key={item.id}>
          <img src={item.image} alt="jewelry" className="prod img" />
          <div className="prod title">
            <div className="prod name">{item.name}</div>
            <div className="prod price">LKR {item.price}</div>
          </div>
          <div className="prod material">{item.material}</div>
          <button className="addToBag" onClick={() => addToBag(item)}>
            Add to Bag
          </button>
        </div>
      ))}
    </div>
  );
}

export default Product;
