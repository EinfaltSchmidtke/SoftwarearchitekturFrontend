import React from 'react'

import Header from './Header'
import Image from './Image'
import Body from './Body'

const ProductCard = (props) => {
    const { product } = props

    if (product) {
        return (
            <div>
                <Header content={product.name} />
                <Image path={product.productImage} />
                <Body desc={product.shortDescription} />
            </div>
        )
    } else {
        return null;
    }
}

export default ProductCard;