package com.mhst.shared.base

/**
 * Created by Moe Htet on 30,August,2020
 */
interface BasePresenter<T : BaseView> {

    fun initPresenter(view: T)

}