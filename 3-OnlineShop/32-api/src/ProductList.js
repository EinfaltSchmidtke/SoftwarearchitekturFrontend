import React, { Component } from 'react'
import axios from 'axios'

import ProductCard from './ProductCard'

class ProductList extends Component {
    state = {
        productData: [],
        isLoading: false
    }

    componentDidMount() {
        this.loadProducts();
    }

    render() {
        const { productData, isLoading } = this.state

        if (isLoading) {
            return <div>Loading...</div>
        } else {
            const getBeerButton = <button onClick={this.handleClick}>Liste meine Biere!</button>
            if (!productData._embedded) {
                return <div>{getBeerButton}</div>
            }

            const productCards = productData._embedded.products.map((product) => {
                return (
                    <ProductCard key={product.id} product={product} onDelete={this.deleteProduct(product)} />
                )
            })
            return (
                <div>
                    {getBeerButton}
                    <div>{productCards}</div>
                </div>
            )
        }
    }

    handleClick = async () => {
        return await this.loadProducts();
    }

    loadProducts = async () => {
        this.setState({ isLoading: true })

        try {
            const response = await axios.get("http://localhost:8080/products/")
            this.setState({ productData: response.data })
        }
        catch (error) {
            alert(error.message)
        }

        this.setState({ isLoading: false })
    }

    deleteProduct = (product) => async () => {
        try {
            await axios.delete(product._links.product.href)
            await this.loadProducts();
        } catch (error) {
            alert(error.message)
        }
    }
}

export default ProductList