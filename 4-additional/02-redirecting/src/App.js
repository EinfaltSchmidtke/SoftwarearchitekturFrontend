import React, { Component } from 'react'
import { Switch, Route, Link } from 'react-router-dom'
import styled from 'styled-components/macro'

import Error from './Error'
import FOF from './FOF'
import Home from './Home'

const Nav = styled.div`
  & > a:not(:last-of-type){
    margin-right: 1rem;
  }`

class App extends Component {
  render () {
    return (
      <div className="App">
          <Nav>
            <Link to='/'>Home</Link>
          </Nav>
          <Switch>
            <Route exact path='/' component={Home} />
            <Route path='/error' component={Error}/>
            <Route component={FOF} />
          </Switch>
      </div>
    );
  }
}

export default App;
