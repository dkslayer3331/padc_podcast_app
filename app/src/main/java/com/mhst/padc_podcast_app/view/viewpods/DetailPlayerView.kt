package com.mhst.padc_podcast_app.view.viewpods

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.util.Log
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerControlView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import kotlinx.android.synthetic.main.detail_player_view.view.*

/**
 * Created by Moe Htet on 07,October,2020
 */
class DetailPlayerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : PlayerControlView(context, attrs, defStyleAttr) {

    private var playWhenReady = false
    private var currentWindow = 0
    private var playbackPosition: Long = 0
    private val exoPlayerEventListener = object : Player.EventListener {
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

    fun bindRandomPodcast(podcastWrapperVo: PodcastWrapperVo){
        val dataSourceFactory: DataSource.Factory =
            DefaultDataSourceFactory(context, "ExoPlayer")
        val uri = Uri.parse(podcastWrapperVo.audio)
        val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
        simpleExoplayer?.playWhenReady = playWhenReady
        simpleExoplayer?.seekTo(currentWindow, playbackPosition)
        simpleExoplayer?.addListener(exoPlayerEventListener)
        simpleExoplayer?.prepare(mediaSource, false, false)
    }

    fun releasePlayer(){
        if (simpleExoplayer != null) {
            playWhenReady = simpleExoplayer!!.playWhenReady
            playbackPosition = simpleExoplayer!!.currentPosition
            currentWindow = simpleExoplayer!!.currentWindowIndex
            simpleExoplayer?.removeListener(exoPlayerEventListener)
            simpleExoplayer?.release()
            simpleExoplayer = null
        }
    }

    private fun initPlayer(){
        simpleExoplayer = SimpleExoPlayer.Builder(context).build()
        if(simpleExoplayer != null){
            detail_player_view.player = simpleExoplayer
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        initPlayer()
    }

}