import React, { Component } from 'react'
import axios from 'axios'

import Header from './Header'
import Image from './Image'
import Body from './Body'

class ProductCard extends Component {
    state = {
        product: {},
        isLoading: false
    }

    componentDidMount() {
        const id = this.props.match.params.id;
        this.fetchProduct(id);
    }

    fetchProduct = async (id) => {
        this.setState({ isLoading: true })

        try {
            const response = await axios.get(`http://localhost:8080/products/${id}`)
            this.setState({ product: response.data })
        }
        catch (error) {
            alert(error.message)
        }
        
        this.setState({ isLoading: false })
    }

    render() {
        const { product, isLoading } = this.state

        if (isLoading) {
            return <div>Loading...</div>
        } else {
            return (
                <div>
                    <Header content={product.name}/>
                    <Image path={product.productImage}/>
                    <Body desc={product.shortDescription}/>
                </div>
            )
        }
    }
}

export default ProductCard