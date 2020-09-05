package com.mhst.padc_podcast_app.data.model

import androidx.lifecycle.LiveData
import com.mhst.padc_podcast_app.data.vo.GenreVO

/**
 * Created by Moe Htet on 05,September,2020
 */
interface PodcastModel {

    fun getAllGenres(onError: (String) -> Unit) : LiveData<List<GenreVO>>

    fun getGenresAndSaveToDb(onSuccess: () -> Unit,onError : (String) -> Unit)

}