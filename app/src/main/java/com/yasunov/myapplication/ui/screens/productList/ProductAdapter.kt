package com.yasunov.myapplication.ui.screens.productList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yasunov.myapplication.R
import com.yasunov.myapplication.data.model.Product
import com.yasunov.myapplication.domain.loadImage


class ProductAdapter : PagingDataAdapter<Product, ProductAdapter.ProductViewHolder>(
    ItemCallback
) {

    inner class ProductViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.product_image)
        private val titleTextView: TextView = itemView.findViewById(R.id.product_title)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.product_description)
        private val priceTextView: TextView = itemView.findViewById(R.id.product_price)
        private val ratingTextView: TextView = itemView.findViewById(R.id.product_rating)
        private var product: Product? = null

        fun bind(product: Product?) {
            this.product = product
            loadImage(product?.thumbnail, imageView)
            titleTextView.text = product?.title?.take(15)
            descriptionTextView.text = product?.desc?.take(100).also { if (it?.length!! > 100) it.plus("...") }
            priceTextView.text =
                itemView.context.getString(R.string.product_price, product?.price.toString())
            ratingTextView.text = product?.rating.toString()
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false),
        )
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object {
        object ItemCallback : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }
        }
    }
}

