package com.vinted.ktworkshop.steps

import android.os.Bundle
import com.bumptech.glide.Glide
import com.vinted.ktworkshop.BaseActivity
import com.vinted.ktworkshop.R
import com.vinted.ktworkshop.models.Item
import kotlinx.android.synthetic.main.activity_step_two.image_step_two as image
import kotlinx.android.synthetic.main.activity_step_two.skip_btn_step_one as skipBtn

/**
 * 2. Add button component (Button) into and on click make it call `presenter.skipItem()`
 */
class StepTwoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_two)
        skipBtn.setOnClickListener {
            presenter.skipItem()
        }
    }

    override fun showItem(item: Item) {
        Glide.with(this).load(item.photos.first().url).into(image)
    }
}