package com.vinted.ktworkshop

import android.os.Bundle

/**
 * 5. Create [RecyclerView adapter](https://developer.android.com/training/material/lists-cards.html).
 *    Override `showLikedItems`, where you need to add items to your created adapter and attach
 *    to `RecyclerView`. Create new layout where you will display item photo and title.
 */

class LikesActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_likes)
    }
}