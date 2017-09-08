package com.vinted.ktworkshop.steps

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.vinted.ktworkshop.BaseActivity
import com.vinted.ktworkshop.R
import com.vinted.ktworkshop.models.Item
import kotlinx.android.synthetic.main.activity_step_five.*
import kotlinx.android.synthetic.main.recycler_step_five.view.*

/**
 * 5. Create RecyclerView adapter https://developer.android.com/training/material/lists-cards.html.
 *    Implement `showLikedItems`, where you need to add items to your created adapter and attach
 *    to `RecyclerView`.
 */
class StepFiveActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_five)
        presenter.getLikedItems()
    }

    override fun showLikedItems(items: List<Item>) {
        recycler_step_five.layoutManager = LinearLayoutManager(this)
        recycler_step_five.adapter = LikedItemsAdapter(items)
    }

    inner class LikedItemsAdapter(
            private val items: List<Item>
    ) : RecyclerView.Adapter<LikedItemsAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
                ViewHolder(
                        LayoutInflater.from(parent.context).inflate(
                                R.layout.recycler_step_five,
                                parent,
                                false
                        )
                )

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]
            Glide.with(holder.itemView.context).load(item.photos.first().url).into(holder.itemView.item_image)
            holder.itemView.item_title.text = item.title
        }

        override fun getItemCount() = items.count()

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    }
}

