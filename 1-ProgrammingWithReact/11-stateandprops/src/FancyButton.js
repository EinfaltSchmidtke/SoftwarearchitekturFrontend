import React, { Component } from 'react'

import './FancyButton.css'

class FancyButton extends Component {
    constructor(props) {
        super(props)
        this.state = {
            content: props.content
        }
    }

    render() {
        var { content } = this.state
        return (
            <button className="FancyButton">
                {content}
            </button>
        )
    }
}

export default FancyButton