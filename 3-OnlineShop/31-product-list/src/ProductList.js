import React, { Component } from 'react'

import ProductCard from './ProductCard'

class ProductList extends Component {
    state = {
        productData: [
            {
                name: 'Oettinger Pils',
                shortDescription: 'Kräftig gehopftes Biererlebnis, dabei schlank und elegant, feinherb, Schaumkrone wie frisch vom Fass.',
                productImage: 'https://www.oettinger-bier.de/wp-content/uploads/2020/02/Pils-1.png'
            },
            {
                name: 'Veltins Pilsener',
                shortDescription: 'Premium-Genuss in geschmacksreicher Vielfalt!',
                productImage: 'https://getraenke-uhe.de/media/image/d0/05/dc/1_424340_VELTINS_Flasche_REL_DYN_033.jpg'
            }
        ]
    }

    render() {
        const { productData } = this.state

        const productCards = productData.map((product) => {
            return (
                <ProductCard key={product.id} product={product} />
            )
        })

        return (
            <div>
                Products:
                <div>{productCards}</div>
            </div>
        )
    }

}

export default ProductList;