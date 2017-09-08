package com.vinted.ktworkshop.presenter

import android.util.Log
import com.vinted.ktworkshop.interactor.DataInteractor
import com.vinted.ktworkshop.view.DisplayView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.*

class ItemPresenterImpl(
        private val interactor: DataInteractor,
        private val view: DisplayView
) : ItemPresenter {

    private val disposables = CompositeDisposable()
    private val skippedItemsIds = mutableListOf<Int>()

    fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start

    override fun loadInitial() {
        interactor.getItems()
                .map { it.items }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val item = it.first()
                    skippedItemsIds.add(item.id)
                    view.showItem(item)
                }, {
                    Log.e("APP", it.message)
                }).apply { disposables.add(this) }
    }

    override fun skipItem() {
        interactor.getItems()
                .map { it.items.filter { !skippedItemsIds.contains(it.id) } }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.isNotEmpty()) {
                        val item = it[(0 until it.size).random()]
                        skippedItemsIds.add(item.id)
                        view.showItem(item)
                    }
                }, {
                    Log.e("APP", it.message)
                }).apply { disposables.add(this) }
    }

    override fun likeItem(id: Int) {
        interactor.likeItem(id)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete { skipItem() }
                .subscribe({
                    view.itemLiked()
                }, {
                    Log.e("APP", it.message)
                }).apply { disposables.add(this) }
    }

    override fun getLikedItems() {
        interactor.likedItems()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showLikedItems(it)
                }, {
                    Log.e("APP", it.message)
                }).apply { disposables.add(this) }
    }

    override fun detach() {
        disposables.clear()
    }
}