package com.vinted.ktworkshop.interactor

import com.vinted.ktworkshop.models.Item
import com.vinted.ktworkshop.models.Items
import io.reactivex.Completable
import io.reactivex.Single

interface DataInteractor {
    fun getItems(): Single<Items>
    fun likeItem(int: Int): Completable
    fun likedItems(): Single<List<Item>>
}