package com.mhst.padc_podcast_app.mvp.view

import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.mvp.BaseView

/**
 * Created by Moe Htet on 05,September,2020
 */
interface GenreView : BaseView {
    fun displayGenres(genres : List<GenreVO>)
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun showError(message : String)
}