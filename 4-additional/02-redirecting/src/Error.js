import React from 'react'

const Error = (props) => {
    return (
        <div>
            <p>{props.location.errorMessage}</p>
        </div>
    )
}

export default Error