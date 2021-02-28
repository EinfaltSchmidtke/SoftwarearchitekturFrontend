import react, { Component } from 'react';

import Header from './Header.js'

class App extends Component {
  state = {
    name: "Max",
    surName: "Mustermann",
    age: 22,
    gender: "male",
    editMode: true 
  }

  constructor(props) {
    super(props)

    /*
    this.changeViewEditMode = this.changeViewEditMode.bind(this)
    this.handleChange = this.handleChange.bind(this)
    */
  }

  changeViewEditMode = () => {
    this.setState({editMode: !this.state.editMode})
  }
  
  handleChange = (event) => {
    this.setState({[event.target.name]: event.target.value});
  }

  handleSubmit ( event ) {
    event.preventDefault();
  }

  render () {
    if (this.state.editMode == false)
    {
      return (
        <div>
        <Header changeViewEditMode={this.changeViewEditMode}></Header>
        <p>{this.state.name}</p>
        <p>{this.state.surName}</p>
        <p>{this.state.age}</p>
        <p>{this.state.gender}</p>
      </div>
      )
    }
    else
    {
      return (
      <div>
        <Header changeViewEditMode={this.changeViewEditMode}></Header>
        <form onSubmit={this.handleSubmit}>
          <label htmlFor="name">
            <input type="text" name="name" onChange={this.handleChange} value={this.state.name} />
          </label>
          <label htmlFor="surName">
            <input type="text" name="surName" onChange={this.handleChange} value={this.state.surName} />
          </label>
          <label htmlFor="age">
            <input type="number" name="age" onChange={this.handleChange} value={this.state.age} />
          </label>
          <label htmlFor="gender">
            <input type="text" name="gender" onChange={this.handleChange} value={this.state.gender} />
          </label>
          <button type="submit" value="submit">Submit</button>
        </form>
      </div>
      )
    }
  }

}

export default App;
