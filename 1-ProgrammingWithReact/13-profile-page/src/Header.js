import React, {Component} from 'react'

class Header extends Component {

    render () {
        return (
            <button onClick={this.props.changeViewEditMode}>Change view/edit mode</button>
        )
    }
}

export default Header;