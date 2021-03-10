import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios'

class ProductList extends Component {
    state = {
        products: [],
        isLoading: false
    }

    render() {
        const { products, isLoading } = this.state

        const productLinks = products.map((product) => {
            return (
                <div key={product.id}>
                    <Link to={{pathname: `/products/${product.id}`}}>
                        {product.name}
                    </Link> 
                </div>
            )
        })

        if (isLoading) {
            return <div>Loading...</div>
        } else {
            return (
                <div>{productLinks}</div>
            )
        }
    }

    componentDidMount = async () => {
        this.setState({ isLoading: true })

        try {
            const response = await axios.get("http://localhost:8080/Products/")
            this.setState({ products: response.data })
        }
        catch (error) {
            alert(error.message)
        }

        this.setState({ isLoading: false })
    }
}

export default ProductList