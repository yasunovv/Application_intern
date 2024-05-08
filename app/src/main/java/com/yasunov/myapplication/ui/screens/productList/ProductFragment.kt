package com.yasunov.myapplication.ui.screens.productList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yasunov.myapplication.R
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class ProductFragment(
): Fragment() {

    private lateinit var productRecyclerView: RecyclerView
    private val productAdapter: ProductAdapter = ProductAdapter()

    private val productViewModel: ProductViewModel by viewModels {
        ProductViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.product_list, container, false)
        productRecyclerView = view.findViewById(R.id.product_recycle_view)
        productRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = productAdapter
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            productViewModel.products
                .collectLatest { pagingData ->
                    productAdapter.submitData(lifecycle, pagingData)
                }
        }
    }




}