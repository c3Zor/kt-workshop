package com.vinted.ktworkshop

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.vinted.ktworkshop.interactor.DataInteractorImpl
import com.vinted.ktworkshop.presenter.ItemPresenter
import com.vinted.ktworkshop.presenter.ItemPresenterImpl
import com.vinted.ktworkshop.view.DisplayView

open class BaseActivity : AppCompatActivity(), DisplayView {

    val presenter: ItemPresenter by lazy {
        ItemPresenterImpl(DataInteractorImpl(
                resources,
                application.getSharedPreferences("KtWorkshop", Context.MODE_PRIVATE)),
                this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.loadInitial()
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }
}