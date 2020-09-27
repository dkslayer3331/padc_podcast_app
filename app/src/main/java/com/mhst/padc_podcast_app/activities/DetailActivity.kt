package com.mhst.padc_podcast_app.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.data.vo.PlaylistVo

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    companion object{

        const val IE_PODCAST = "IE_PODCAST"

        fun onNewIntent(context: Context,playlistVo: PlaylistVo) : Intent{
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra(IE_PODCAST, Gson().toJson(playlistVo))
            return intent
        }
    }

}