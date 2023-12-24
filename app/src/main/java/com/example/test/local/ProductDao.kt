package com.example.test.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.test.data.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product)

    @Delete
    suspend fun delete(product: Product)

    @Query("SELECT * FROM product")
    fun getAllProducts(): LiveData<List<Product>>
}

