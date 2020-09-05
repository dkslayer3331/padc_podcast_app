package com.mhst.padc_podcast_app.mvp

/**
 * Created by Moe Htet on 05,September,2020
 */
interface BasePresenter<T : BaseView> {

    fun initPresenter(view: T)

}