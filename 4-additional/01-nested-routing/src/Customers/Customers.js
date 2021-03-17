import { Link, Route, Switch } from 'react-router-dom'

import styled from 'styled-components/macro'

import New from './New'
import Home from './Home'

const Nav = styled.div`
  & > a:not(:last-of-type){
    margin-right: 1rem;
  }`

const Customers = ({ match }) => {
    return (
        <div>
            <h3>Customers</h3>
            <Nav>
                <Link to={`${match.url}`}>Home</Link>
                <Link to={`${match.url}/new`}>New</Link>
            </Nav>
            <Switch>
                <Route exact path={`${match.url}/`} component={Home} />
                <Route path={`${match.url}/new`} component={New} />
            </Switch>
        </div>
    )
}

export default Customers