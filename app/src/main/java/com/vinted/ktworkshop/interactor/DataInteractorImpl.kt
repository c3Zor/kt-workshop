package com.vinted.ktworkshop.interactor

import android.content.SharedPreferences
import android.content.res.Resources
import com.google.gson.GsonBuilder
import com.vinted.ktworkshop.R
import com.vinted.ktworkshop.models.Item
import com.vinted.ktworkshop.models.Items
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.io.IOException
import java.io.InputStream

class DataInteractorImpl(
        private val resources: Resources,
        private val sharedPreferences: SharedPreferences
) : DataInteractor {

    private val gson = GsonBuilder().create()
    private var items: Items = Items()

    override fun getItems(): Single<Items> {
        return if (items.items.isEmpty()) {
            Single.just(gson.fromJson<Items>(getDataFromRaw(R.raw.items), Items::class.java))
                    .subscribeOn(Schedulers.io())
                    .doOnSuccess { items = it }
        } else {
            Single.just(items)
        }
    }

    override fun likeItem(id: Int): Completable {
        return Completable.create {
            val editor = sharedPreferences.edit()
            val likedItemIds = sharedPreferences.getStringSet(LIKED_ITEMS, setOf())
            val setOfLikedItems = likedItemIds.plus(id.toString())
            editor.putStringSet(LIKED_ITEMS, setOfLikedItems).apply()
            it.onComplete()
        }
    }

    override fun likedItems(): Single<List<Item>> {
        val listOfInts: List<Int> = sharedPreferences.getStringSet(LIKED_ITEMS, setOf())
                .toList()
                .map { item -> item.toInt() }
        return getItems().map { it.items.filter { listOfInts.contains(it.id) } }

    }

    private fun readFile(inputStream: InputStream): String =
            inputStream.bufferedReader().use { it.readText() }

    private fun getDataFromRaw(resourceId: Int): String? {
        return try {
            val inputStream = resources.openRawResource(resourceId)
            readFile(inputStream)
        } catch (e: IOException) {
            null
        }
    }

    companion object {
        private const val LIKED_ITEMS = "ITEMS"
    }
}