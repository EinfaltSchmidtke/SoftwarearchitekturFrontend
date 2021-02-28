import React from 'react'

const FunctionalButton = (props) => {
    const { onButtonClick, increment } = props
    return (
        <button onClick={onButtonClick(increment)}>
            Count {increment}
        </button>
    )
}

export default FunctionalButton
