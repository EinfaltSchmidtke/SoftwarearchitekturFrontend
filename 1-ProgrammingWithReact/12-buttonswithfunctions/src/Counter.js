import React, { Component } from 'react'

import Button from './Button.js'

class Counter extends Component {
    state = {
        count: 0
    }
    render() {
        return (
            <div>
                <h1>Current Count: {this.state.count}</h1>
                <Button onButtonClick={this.handleClick} increment={1} />
                <Button onButtonClick={this.handleClick} increment={5} />
                <Button onButtonClick={this.handleClick} increment={-1} />
                <Button onButtonClick={this.handleClick} increment={-this.state.count} />
            </div>
        )
    }

    handleClick = (increment) => () => {
        let newCount = this.state.count + increment
        this.setState({ count: newCount })
    }
}

export default Counter