import React, { Component } from 'react'
import styled from 'styled-components'
import axios from 'axios'
import { Redirect } from 'react-router-dom'

const Form = styled.form``
const Input = styled.input``
const Button = styled.button``

class Home extends Component {
    state = {
        url: 'http://localhost8080/resourceNotFound/',
        isLoading: false,
        error: null
    }

    render() {
        const { url, isLoading, error } = this.state

        if (error) {
            return (
                <Redirect
                    push to={{
                    pathname: "/error",
                    errorMessage: error.message 
                    }}
                />
              )
        }
        else if (isLoading) {
            return <div>Loading...</div>
        }
        else {
            return (
                <div>
                    <Form onSubmit={this.handleSubmit}>
                        <Input type='text' name='url' value={url} onChange={this.handleChange} />
                        <Button type='submit'>GET</Button>
                    </Form>
                </div>
            )
        }
    }

    handleChange = (event) => {
        const inputValue = event.target.value
        const inputName = event.target.name
    
        this.setState({ [inputName]: inputValue })
      }
    
      handleSubmit = async (event) => {
        // This is to prevent the page from rerendering
        event.preventDefault()
        
        this.setState({ isLoading: true })
        
        const { url } = this.state
        if (url) {
            try {
                const response = await axios.get(url)
    
                console.log(response.data)
            }
            catch (error) {
                this.setState({error: error})
            }
        } else {
            alert("Bitte gib eine URL ein")
        }
    
        this.setState({ isLoading: false })
      }
}

export default Home