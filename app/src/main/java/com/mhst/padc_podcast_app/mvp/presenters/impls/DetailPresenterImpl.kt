package com.mhst.padc_podcast_app.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.mvp.AbstractBasePresenter
import com.mhst.padc_podcast_app.mvp.presenters.DetailPresenter
import com.mhst.padc_podcast_app.mvp.view.DetailView

/**
 * Created by Moe Htet on 27,September,2020
 */
class DetailPresenterImpl : AbstractBasePresenter<DetailView>(), DetailPresenter {
    override fun onUiReady(lifecycleOwner: LifecycleOwner, playlistVo: PlaylistVo) {
        mView?.binData(playlistVo)
    }
}