package com.mhst.padc_podcast_app.mvp

import androidx.lifecycle.ViewModel

/**
 * Created by Moe Htet on 05,September,2020
 */
abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}
