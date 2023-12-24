package com.example.test.screen.tab4

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.utlis.listener.OnItemRecyclerViewClickListener
import com.example.test.data.Product
import com.example.test.databinding.ItemProductBinding
import com.example.test.utils.ext.notNull

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder?>() {

    private val products = mutableListOf<Product>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<Product>? = null

    fun setData(products: List<Product>?) {
        products.notNull {
            this.products.clear()
            this.products.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<Product>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewBinding = ItemProductBinding.inflate(inflater, parent, false)
        return ViewHolder(viewBinding, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)
        holder.viewBinding.apply {
            product.let {
                textId?.text = it.id.toString()
                textFirstName?.text = it.firstName
                textLastName?.text = it.lastName
                textPosition?.text = it.position

                btnDelete.setOnClickListener {
                    onItemClickListener?.onItemClick(product)
                }
            }
        }
    }

    inner class ViewHolder(
        var viewBinding: ItemProductBinding,
        listener: OnItemRecyclerViewClickListener<Product>?
    ) : RecyclerView.ViewHolder(viewBinding.root) {

    }
}