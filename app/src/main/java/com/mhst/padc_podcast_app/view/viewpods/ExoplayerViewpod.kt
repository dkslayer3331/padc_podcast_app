package com.mhst.padc_podcast_app.view.viewpods

import android.content.Context
import android.util.AttributeSet
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerControlView

/**
 * Created by Moe Htet on 26,September,2020
 */
class ExoplayerViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : PlayerControlView(context, attrs, defStyleAttr) {

    private var playWhenReady = false
    private var currentWindow = 0
    private var playbackPosition: Long = 0
    //private val exoPlayerEventListener = ExoPlayerEventListener()
    private var simpleExoplayer: SimpleExoPlayer? = null

    fun bindData(url : String){

    }

    override fun onFinishInflate() {
        super.onFinishInflate()

    }

    private fun initPlayer(){

    }

}