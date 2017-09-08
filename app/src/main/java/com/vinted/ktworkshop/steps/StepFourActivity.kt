package com.vinted.ktworkshop.steps

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.vinted.ktworkshop.BaseActivity
import com.vinted.ktworkshop.R
import com.vinted.ktworkshop.models.Item
import kotlinx.android.synthetic.main.activity_step_four.image_step_four as image
import kotlinx.android.synthetic.main.activity_step_four.like_btn_step_four as likeBtn
import kotlinx.android.synthetic.main.activity_step_four.show_likes as showLikesBtn
import kotlinx.android.synthetic.main.activity_step_four.skip_btn_step_four as skipBtn

/**
 * 4. Add button which will navigate to new empty activity.
 */
class StepFourActivity : BaseActivity() {

    private var currentItemId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_four)
        skipBtn.setOnClickListener {
            presenter.skipItem()
        }
        likeBtn.setOnClickListener {
            presenter.likeItem(currentItemId)
        }
        showLikesBtn.setOnClickListener {
            val intent = Intent(this, StepFiveActivity::class.java)
            startActivity(intent)
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