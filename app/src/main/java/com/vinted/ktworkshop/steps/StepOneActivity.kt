package com.vinted.ktworkshop.steps

import android.os.Bundle
import com.bumptech.glide.Glide
import com.vinted.ktworkshop.BaseActivity
import com.vinted.ktworkshop.R
import com.vinted.ktworkshop.models.Item
import kotlinx.android.synthetic.main.activity_step_one.image_step_one as image

/**
 * 1. Add image component (ImageView) - https://developer.android.com/training/basics/firstapp/building-ui.html
 *    Display item image using Glide library. - http://bumptech.github.io/glide/#api
 *    You entry function is `showItem()`, where you can access Item data model which consists array of photos,
 *    but you only need to show first one.
 */
class StepOneActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_one)
    }

    override fun showItem(item: Item) {
        Glide.with(this).load(item.photos.first().url).into(image)
    }
}