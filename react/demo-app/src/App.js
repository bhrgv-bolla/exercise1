import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import PhotoGallery from "./demo";

const images = [
    {
        url: 'http://lorempixel.com/1000/600/nature/1/',
        caption: "one pic",
    },
    {
        url: 'http://lorempixel.com/1000/600/nature/3/',
        caption: "two pic",
    }
];

class App extends Component {
  render() {
    return (

          <PhotoGallery data={images}/>
    );
  }
}

export default App;
