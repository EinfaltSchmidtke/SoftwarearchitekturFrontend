import React, {Component} from 'react'

class List extends Component{

    constructor(props){
        super(props);
        this.state = {
            listItems: props.children
        }
    }

    render(){
        let { listItems } = this.state;
        return (
            <ul>
                {listItems}
            </ul>
        )
    }
}

export default List