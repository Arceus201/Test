package com.example.test.screen.tab4

import com.example.test.data.Product

class Tab4Contract {

    interface View {
        fun showProducts(products: List<Product>)
        fun showErrorMessage(message: String)
    }

    interface Presenter {
        suspend fun getAllProducts()
        suspend fun insertProduct(product: Product)
        suspend fun deleteProduct(product: Product)
    }
}