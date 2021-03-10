import React, { Component } from 'react'

import Header from './Header'
import Image from './Image'
import Body from './Body'

class ProductCard extends Component {
    render() {
        const { product, onDelete } = this.props
        return (
            <div>
                <Header content={product.name} />
                <button onClick={onDelete}>Dieses Produkt löschen</button>
                <Image path={product.productImage} />
                <Body desc={product.shortDescription} />
            </div>
        )
    }
}

export default ProductCard