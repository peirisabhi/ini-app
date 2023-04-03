import React, { useState, useEffect } from "react";
import "./Slideshow.css";
import { SlideshowImages } from "./SlideshowImages";
import { VscChevronLeft, VscChevronRight } from "react-icons/vsc";
import { Link } from "react-router-dom";

const Slideshow = ({ slides }) => {
  const [current, setCurrent] = useState(0);
  const length = slides.length;

  const nextSlide = () => {
    setCurrent(current === length - 1 ? 0 : current + 1);
  };

  const prevSlide = () => {
    setCurrent(current === 0 ? length - 1 : current - 1);
  };

  useEffect(() => {
    const slide = setTimeout(() => setCurrent(nextSlide), 5000);
    return () => clearTimeout(slide);
  });

  return (
    <div className="slider">
      <VscChevronLeft className="left-arrow" onClick={prevSlide} />
      <VscChevronRight className="right-arrow" onClick={nextSlide} />
      {SlideshowImages.map((slide, index) => {
        return (
          <div
            className={index === current ? "slide active" : "slide"}
            key={index}
          >
            {index === current && (
              <div>
                <img src={slide.image} alt="jewelry" className="photo" />
                <Link to={slide.link}>
                  <button className="slide-button">{slide.caption}</button>
                </Link>
              </div>
            )}
          </div>
        );
      })}
    </div>
  );
};

export default Slideshow;
