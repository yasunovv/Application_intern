package com.yasunov.myapplication.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yasunov.myapplication.data.model.Product


private val TAG = ProductPageService::class.simpleName!!

class ProductPageService(private val api: DummyApi) : PagingSource<Int, Product>() {
    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        try {

            val page = params.key ?: 1
            val pageSize = params.loadSize

            val productList = api.getUsers(
                30,
                if (page == 1) 0 else pageSize * page
            ).products.map { it.toProduct() }
            val nextKey = if (productList.size < pageSize) null else page + 1
            val prevKey = if (page == 1) null else page - 1
            return LoadResult.Page(
                data = productList,
                nextKey = nextKey,
                prevKey = prevKey
            )

        } catch (e: Exception) {
            return LoadResult.Error(e)
        }

    }
}