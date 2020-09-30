package com.mhst.padc_podcast_app.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.mvp.presenters.DetailPresenter
import com.mhst.padc_podcast_app.mvp.presenters.impls.DetailPresenterImpl
import com.mhst.padc_podcast_app.mvp.view.DetailView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(),DetailView {

    lateinit var mDetailPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val jsonStr = intent.getStringExtra(IE_PODCAST)

        val data = Gson().fromJson(jsonStr,PodcastWrapperVo::class.java)

        setupPresenter()

        mDetailPresenter.onUiReady(this,data)

    }

    private fun setupPresenter(){
        mDetailPresenter = ViewModelProvider(this)[DetailPresenterImpl::class.java]
        mDetailPresenter.initPresenter(this)
    }

    companion object{

        const val IE_PODCAST = "IE_PODCAST"

        fun onNewIntent(context: Context,podcastWrapperVo: PodcastWrapperVo) : Intent{
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra(IE_PODCAST, Gson().toJson(podcastWrapperVo))
            return intent
        }
    }

    override fun binData(podcastWrapperVo: PodcastWrapperVo) {
            Glide.with(this).load(podcastWrapperVo.image).into(ivDetailBanner)
            tvDetailTitle.text = podcastWrapperVo.title
            tvDetailDesc.text = Html.fromHtml(podcastWrapperVo.description)
    }

    override fun binAudio(url: String) {

    }

}