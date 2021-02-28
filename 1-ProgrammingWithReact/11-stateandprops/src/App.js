import React from 'react'

import Header from './Header'
import Button from './Button'
import FancyButton from './FancyButton'
import List from './List'

const App = () => {
    return (
        <div>
            <Header>This is a children Headline</Header>
            <Button content="Buttontext" />
            <FancyButton content="Beautiful Buttontext" />
            <List>
                <li>First</li>
                <li>Second</li>
                <li>Third</li>
            </List>
        </div>
    )
}

export default App