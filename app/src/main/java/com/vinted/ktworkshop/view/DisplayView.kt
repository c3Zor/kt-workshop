package com.vinted.ktworkshop.view

import com.vinted.ktworkshop.models.Item

interface DisplayView {
    fun showItem(item: Item) {}
    fun likeItem(id: Int) {}
    fun itemLiked() {}
    fun showLikedItems(items: List<Item>) {}
}