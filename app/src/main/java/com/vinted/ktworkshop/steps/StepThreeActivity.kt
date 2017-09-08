package com.vinted.ktworkshop.steps

import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.vinted.ktworkshop.BaseActivity
import com.vinted.ktworkshop.R
import com.vinted.ktworkshop.models.Item
import kotlinx.android.synthetic.main.activity_step_three.image_step_three as image
import kotlinx.android.synthetic.main.activity_step_three.like_btn_step_three as likeBtn
import kotlinx.android.synthetic.main.activity_step_three.skip_btn_step_three as skipBtn

/**
 * 3. Add button which will act as a `Like` and on click make it call
 *    `presenter.likeItem()` (pass id of item which you currently showing).
 *    Implement some action, maybe display `Toast` by overriding `itemLiked()` method.
 *    https://developer.android.com/guide/topics/ui/notifiers/toasts.html
 */
class StepThreeActivity : BaseActivity() {

    private var currentItemId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_three)
        skipBtn.setOnClickListener {
            presenter.skipItem()
        }
        likeBtn.setOnClickListener {
            presenter.likeItem(currentItemId)
        }
    }

    override fun showItem(item: Item) {
        currentItemId = item.id
        Glide.with(this).load(item.photos.first().url).into(image)
    }

    override fun itemLiked() {
        Toast.makeText(this, "Item liked", Toast.LENGTH_SHORT).show()
    }
}