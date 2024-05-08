package com.yasunov.myapplication.data.network

import com.yasunov.myapplication.data.model.Product
import com.yasunov.myapplication.data.network.model.ProductDto

internal fun ProductDto.toProduct(): Product {
    return Product(
        id = id,
        price = price,
        title = title,
        desc = desc,
        rating = rating,
        thumbnail = thumbnail
    )
}