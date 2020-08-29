package com.mhst.shared.base

import com.mhst.padc_podcast_app.base.BaseView

/**
 * Created by Moe Htet on 30,August,2020
 */
interface BasePresenter<T : BaseView> {

    fun initPresenter(view: T)

}