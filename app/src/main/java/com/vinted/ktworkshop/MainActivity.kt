package com.vinted.ktworkshop

import android.os.Bundle

/**
 * 1. Add image component (ImageView) - https://developer.android.com/training/basics/firstapp/building-ui.html
 *    Display item image using Glide library. - http://bumptech.github.io/glide/#api
 *    You entry function is `showItem()`, where you can access Item data model which consists array of photos,
 *    but you only need to show first one.
 *
 * 2. Add button component (Button) into and on click make it call `presenter.skipItem()`
 *
 * 3. Add button which will act as a `Like` and on click make it call
 *    `presenter.likeItem()` (pass id of item which you currently showing).
 *    Implement some action, maybe display `Toast` by overriding `itemLiked()` method.
 *    https://developer.android.com/guide/topics/ui/notifiers/toasts.html
 *
 * 4. Add button which will navigate to new `LikesActivity`.
 *    https://developer.android.com/training/basics/firstapp/starting-activity.html
 **/

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
