import "./style.css";
import "@fontsource/quicksand";
import Header from "./Header";
import Slideshow from "./Slideshow";
import { SlideshowImages } from "./SlideshowImages";
import Content from "./Content";
import Footer from "./Footer";
import BodySection from "./BodySection";

function Home(props) {
  const { bag, bagCount } = props;
  return (
    <div>
      <Header bag={bag} bagCount={bagCount} />
      <Content />
      <Slideshow slides={SlideshowImages} />
      <BodySection />
      <Footer />
    </div>
  );
}

export default Home;
