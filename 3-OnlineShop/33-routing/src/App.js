import { Route, Link, Switch } from 'react-router-dom'

import styled from 'styled-components/macro'

import Home from './Home'
import CreateProduct from './CreateProduct'
import ProductList from './ProductList'
import About from './About'
import FOF from './FOF'
import ProductCard from './ProductCard'

const Nav = styled.div`
  & > a:not(:last-of-type){
    margin-right: 1rem;
  }`

const App = () => {
  return (
    <div className="App">
      <Nav>
        <Link to='/'>Home</Link>
        <Link to='/createproduct'>Create Product</Link>
        <Link to='/products'>Products</Link>
        <Link to='/about'>About</Link>
      </Nav>
      <Switch>
        <Route exact path='/' component={Home} />
        <Route path='/createproduct' component={CreateProduct}/>
        <Route path='/products' component={ProductList} />
        <Route path='/about' component={About} />
        <Route path='/products/:id' component={ProductCard} />
        <Route component={FOF} />
      </Switch>
    </div>
  );
}

export default App;
