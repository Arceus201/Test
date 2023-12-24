package com.example.test.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.test.data.Product
import com.example.test.utils.App

class Repository(private val dao: ProductDao = App.database.productDao()) : BaseRepository() {
    companion object {
        fun getDefault(): Repository {
            return Repository()
        }
    }

    sealed class Result<out T> {
        data class Success<out T>(val data: T) : Result<T>()
        data class Error(val message: String) : Result<Nothing>()
    }


    suspend fun getAll(): LiveData<List<Product>> {
        val resultLiveData = MutableLiveData<List<Product>>()

        doInBackground(
            action = {
                dao.getAllProducts()
            },
            result = {
                resultLiveData.postValue(it as List<Product>?)
            }
        )

        return resultLiveData
    }

    suspend fun insert(product: Product) {
        doInBackground(
            action = {
                dao.insert(product)
            },
            result = {


            }
        )
    }

    suspend fun delete(product: Product) {
        doInBackground(
            action = {
                dao.delete(product)
            },
            result = {}
        )
    }
}
