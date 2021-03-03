import React, { Component } from 'react'

class App extends Component {
  render() {
    fetch('http://localhost:8080/products').then(products => {
      products.json().then(json =>{
        console.log(json);
      })
    })
    return <b>Schau in die Console</b>
  }
}

export default App;
