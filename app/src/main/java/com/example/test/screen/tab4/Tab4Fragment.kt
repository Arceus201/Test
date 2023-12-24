package com.example.test.screen.tab4

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.example.movies.utlis.base.BaseFragment
import com.example.movies.utlis.listener.OnItemRecyclerViewClickListener
import com.example.test.data.Product
import com.example.test.databinding.FragmentTab4Binding

class Tab4Fragment : BaseFragment<FragmentTab4Binding>(
    FragmentTab4Binding::inflate
), OnItemRecyclerViewClickListener<Product> , Tab4Contract.View{
    private val mProductAdapter: ProductAdapter by lazy { ProductAdapter() }
    private lateinit var presenter: Tab4Presenter
    override fun initView(savedInstanceState: Bundle?) {
        binding.recyclerView.adapter = mProductAdapter
    }

    override fun initData() {
        presenter = Tab4Presenter(this)
        presenter.getAllProducts()
    }

    @SuppressLint("SuspiciousIndentation")
    override fun handleEvent() {
        binding.apply {
            btnAdd.setOnClickListener {
            val product =Product(firstName =etFirstName.text.toString(),
            lastName = etLastName.text.toString(),
            position = etPosition.text.toString())
                presenter.insertProduct(
                    product
                )
            }
        }
    }

    override fun onItemClick(item: Product?) {
        item?.let { presenter.deleteProduct(it) }
    }

    override fun showProducts(products: List<Product>) {
        TODO("Not yet implemented")
    }

    override fun showErrorMessage(message: String) {
        TODO("Not yet implemented")
    }

}