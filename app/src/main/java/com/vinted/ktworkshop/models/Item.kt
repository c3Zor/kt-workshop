package com.vinted.ktworkshop.models

import org.parceler.Parcel
import java.io.Serializable

@Parcel
class Item(
        val id: Int = 0,
        val title: String = "",
        val photos: List<Photo> = listOf()
)

@Parcel
class Photo(val url: String = "")

class Items(val items: List<Item> = listOf()) : Serializable