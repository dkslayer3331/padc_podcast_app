package com.mhst.padc_podcast_app.data.model

import android.content.Context
import com.mhst.padc_podcast_app.BASE_URL
import com.mhst.padc_podcast_app.network.PodcastApi
import com.mhst.padc_podcast_app.persistance.database.PodcastDb
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Moe Htet on 05,September,2020
 */
abstract class BaseModel {

    protected var mApi : PodcastApi

    protected lateinit var mDb : PodcastDb

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mApi = retrofit.create(PodcastApi::class.java)

    }

    fun initDb(context: Context){
        mDb = PodcastDb.getDBInstance(context)
    }

}