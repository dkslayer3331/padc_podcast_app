package com.mhst.shared.base

/**
 * Created by Moe Htet on 30,August,2020
 */
import androidx.lifecycle.ViewModel
import com.mhst.padc_podcast_app.base.BaseView

/**
 * Created by Moe Htet on 31,July,2020
 */
abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}