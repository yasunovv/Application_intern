package com.yasunov.myapplication.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


// {"id":1,
// "title":"iPhone 9",
// "description":"An apple mobile which is nothing like apple",
// "price":549,
// "discountPercentage":12.96,
// "rating":4.69,
// "stock":94,
// "brand":"Apple",
// "category":"smartphones",
// "thumbnail":"https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
// "images":["https://cdn.dummyjson.com/product-images/1/1.jpg","https://cdn.dummyjson.com/product-images/1/2.jpg","https://cdn.dummyjson.com/product-images/1/3.jpg","https://cdn.dummyjson.com/product-images/1/4.jpg","https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"]}
@Serializable
data class ProductsDto(
    @SerialName("products")
    val products: List<ProductDto>,
    @SerialName("total")
    val total: Int,

)

@Serializable
data class ProductDto (
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("description") val desc: String,
    @SerialName("price") val price: Int,
    @SerialName("rating") val rating: Double,
    @SerialName("thumbnail") val thumbnail: String
)





