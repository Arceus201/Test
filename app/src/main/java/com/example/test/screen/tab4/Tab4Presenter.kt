package com.example.test.screen.tab4

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.test.data.Product
import com.example.test.local.Repository

class Tab4Presenter(private val view: Tab4Contract.View,
                    private val repository: Repository = Repository.getDefault()): Tab4Contract.Presenter{
    override suspend fun getAllProducts() {
        repository.getAll().observe(view as LifecycleOwner, Observer { products ->
            view.showProducts(products)
        })
    }

    override suspend fun insertProduct(product: Product) {
        repository.insert(product)
    }

    override suspend fun deleteProduct(product: Product) {
        repository.delete(product)
    }

}