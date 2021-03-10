import axios from 'axios'
import React, { Component } from 'react'

import styled from 'styled-components'

const Form = styled.form``
const Label = styled.label``
const Input = styled.input``
const Button = styled.button``

class CreateProduct extends Component {
    state = {
        name: '',
        shortDescription: '',
        productImage: '',
        isLoading: false
    }

    render() {
        const { name, productImage, shortDescription, isLoading } = this.state

        if (isLoading) {
            return <div>Loading...</div>
        }
        else {
            return (
                <div>
                    <Form onSubmit={this.handleSubmit}>
                        <Label htmlFor="name">Produktname:
                        <Input type="text" name="name" id="name" value={name} onChange={this.handleChange} />
                        </Label>
                        <Label htmlFor="shortDescription">Beschreibung:
                        <Input type="text" name="shortDescription" id="shortDescription" value={shortDescription} onChange={this.handleChange} />
                        </Label>
                        <Label htmlFor="productImage">Foto-URL:
                        <Input type="text" name="productImage" id="productImage" value={productImage} onChange={this.handleChange} />
                        </Label>

                        <Button type="submit">Ab dafür</Button>
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

        const product = this.state
        const { name, productImage, shortDescription } = product
        if (name && productImage && shortDescription) {
            try {
                await axios.post("http://localhost:8080/Products/", product)

                this.setState({
                    name: '',
                    shortDescription: '',
                    productImage: ''
                })
            }
            catch (error) {
                alert(error.message)
            }
        } else {
            alert("Da fehlt noch wat")
        }

        this.setState({ isLoading: false })

    }
}

export default CreateProduct