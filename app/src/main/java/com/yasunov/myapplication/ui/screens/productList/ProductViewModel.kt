package com.yasunov.myapplication.ui.screens.productList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.yasunov.myapplication.data.network.DummyApi
import com.yasunov.myapplication.data.network.ProductPageService

class ProductViewModel(
    private val dummyApi: DummyApi
) : ViewModel() {

    val products = Pager(
        config = PagingConfig(
            pageSize = 30, enablePlaceholders = false
        ),
        pagingSourceFactory = { ProductPageService(dummyApi) }
    )
        .flow
        .cachedIn(viewModelScope)

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                return ProductViewModel(
                    dummyApi = DummyApi.invoke()
                ) as T
            }
        }
    }

}