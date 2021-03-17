import { Route, Link, Switch } from 'react-router-dom'

import styled from 'styled-components/macro'

import Home from './Home'
import Products from './Products/Products'
import Customers from './Customers/Customers'

const Nav = styled.div`
  & > a:not(:last-of-type){
    margin-right: 1rem;
  }`

const App = () => {
  return (
    <div className="App">
      <Nav>
        <Link to='/'>Home</Link>
        <Link to='/products'>Products</Link>
        <Link to='/customers'>Customers</Link>
      </Nav>
      <Switch>
        <Route exact path='/' component={Home} />
        <Route path='/products' component={Products} />
        <Route path='/customers' component={Customers} />
      </Switch>
    </div>
  );
}

export default App;
