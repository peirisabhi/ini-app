import Header from './Header';
import Footer from './Footer';

function Comingsoon(props) {
    const { bag, bagCount } = props
    return (
        <div>
            <Header bag={bag} bagCount={bagCount} />
            <div className="comingsoon">Coming soon</div>
            <Footer />
        </div>
    );
}

export default Comingsoon;