package com.vinted.ktworkshop.presenter

interface ItemPresenter {
    fun loadInitial()
    fun skipItem()
    fun likeItem(id: Int)
    fun getLikedItems()

    fun detach()
}