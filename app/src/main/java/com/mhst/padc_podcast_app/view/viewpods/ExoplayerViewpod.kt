package com.mhst.padc_podcast_app.view.viewpods

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.util.Log
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerControlView
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Player.EventListener
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * Created by Moe Htet on 26,September,2020
 */
class ExoplayerViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : PlayerControlView(context, attrs, defStyleAttr) {

    private var playWhenReady = false
    private var currentWindow = 0
    private var playbackPosition: Long = 0
    private val exoPlayerEventListener = object : EventListener{
        override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
            super.onPlayerStateChanged(playWhenReady, playbackState)
        }

        override fun onIsPlayingChanged(isPlaying: Boolean) {
            super.onIsPlayingChanged(isPlaying)
            if (isPlaying) Log.d("Playing", isPlaying.toString())
        }

        override fun onPlayerError(error: ExoPlaybackException) {
            super.onPlayerError(error)
            error.message?.let { Log.d("isPlaying", it) }
        }
    }
    private var simpleExoplayer: SimpleExoPlayer? = null

    fun bindData(url : String){
        val dataSourceFactory: DataSource.Factory =
            DefaultDataSourceFactory(context, "ExoPlayer")
        val uri = Uri.parse(url)
        val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
        simpleExoplayer?.playWhenReady = playWhenReady
        simpleExoplayer?.seekTo(currentWindow, playbackPosition)
        simpleExoplayer?.addListener(exoPlayerEventListener)
        simpleExoplayer?.prepare(mediaSource, false, false)
    }

    fun releasePlayer() {
        if (simpleExoplayer != null) {
            playWhenReady = simpleExoplayer!!.playWhenReady
            playbackPosition = simpleExoplayer!!.currentPosition
            currentWindow = simpleExoplayer!!.currentWindowIndex
            simpleExoplayer?.removeListener(exoPlayerEventListener)
            simpleExoplayer?.release()
            simpleExoplayer = null
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        initPlayer()
    }

    private fun initPlayer(){
        simpleExoplayer = SimpleExoPlayer.Builder(context).build()
        vpHomePlayer.player = simpleExoplayer
    }

}