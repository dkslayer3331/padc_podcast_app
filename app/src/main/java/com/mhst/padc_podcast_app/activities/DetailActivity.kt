package com.mhst.padc_podcast_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.mvp.presenters.DetailPresenter
import com.mhst.padc_podcast_app.mvp.presenters.impls.DetailPresenterImpl
import com.mhst.padc_podcast_app.mvp.view.DetailView
import com.mhst.padc_podcast_app.view.viewpods.DetailPlayerView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity(),DetailView {

    lateinit var mDetailPresenter: DetailPresenter
    
    lateinit var vpDetail : DetailPlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        vpDetail = vpDetailPlayer as DetailPlayerView

        val id = intent.getStringExtra(IE_PODCAST)

        setupPresenter()

        mDetailPresenter.onUiReady(this,id)

    }

    private fun setupPresenter(){
        mDetailPresenter = ViewModelProvider(this)[DetailPresenterImpl::class.java]
        mDetailPresenter.initPresenter(this)
    }

    override fun onStop() {
        super.onStop()
        vpDetail.releasePlayer()
    }

    override fun onPause() {
        super.onPause()
        vpDetail.releasePlayer()
    }

    companion object{

        const val IE_PODCAST = "IE_PODCAST"

        fun onNewIntent(context: Context,id : String) : Intent{
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra(IE_PODCAST,id)
            return intent
        }
    }

    override fun binData(podcastWrapperVo: PodcastWrapperVo) {
            Glide.with(this).load(podcastWrapperVo.image).into(ivDetailBanner)
           // tvDetailTitle.text = podcastWrapperVo.title
            //toolbar.title = podcastWrapperVo.title
            tvDetailTitle.text = podcastWrapperVo.title
            tvDetailDesc.text = Html.fromHtml(podcastWrapperVo.description)
            vpDetail.bindRandomPodcast(podcastWrapperVo)
    }

}