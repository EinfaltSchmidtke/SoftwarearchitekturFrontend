import React, { Component } from 'react'

class Form extends Component {
    state = {
        vorname: "Max",
        nachname: "Mustermann"
    }

    render() {
        return (
            <div>
                Aktueller Vorname: {this.state.vorname} <br/>
                Aktueller Nachname: {this.state.nachname}
                <form onSubmit={this.onSubmit}>
                    <label htmlFor="vorname">Vorname
                    <input type="text" name="vorname" onChange={this.onInputChange} value={this.state.vorname} />
                    </label>
                    <label htmlFor="nachname">Nachname
                    <input type="text" name="nachname" onChange={this.onInputChange} value={this.state.nachname} />
                    </label>
                    <button type="submit">Submit</button>
                </form>
            </div>
        )
    }

    onInputChange = (event) => {
        this.setState({[event.target.name]: event.target.value})
    }

    onSubmit = (event) => {
        event.preventDefault()
        alert(this.state.vorname + ", " + this.state.nachname)
    }
}

export default Form