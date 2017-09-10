package com.vinted.ktworkshop

import android.os.Bundle

/**
 * Main tasks:
 *
 * 1. [Add image component (ImageView)](https://developer.android.com/training/basics/firstapp/building-ui.html).
 *    Display item image using [Glide](http://bumptech.github.io/glide/#api).
 *    You entry function is `showItem()`, where you can access Item data model which consists array of photos,
 *    but you only need to show first one.
 *
 *
 * 2. Add button component (Button) and on click make it call `presenter.skipItem()`
 *
 *
 * 3. Add button which will act as a `Like` and on click make it call
 *    `presenter.likeItem()` (pass id of item which you currently showing).
 *    Implement some action, maybe display [Toast](https://developer.android.com/guide/topics/ui/notifiers/toasts.html) by overriding `itemLiked()` method.
 *
 *
 * 4. Add button which will navigate to new `LikesActivity`.
 *    https://developer.android.com/training/basics/firstapp/starting-activity.html
 *
 * Bonus:
 *
 * 5. Create [RecyclerView adapter](https://developer.android.com/training/material/lists-cards.html).
 *    Override `showLikedItems`, where you need to add items to your created adapter and attach
 *    to `RecyclerView`. Create new layout where you will display item photo and title.
 */

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
