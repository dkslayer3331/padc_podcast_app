package com.mhst.padc_podcast_app.network

import com.mhst.padc_podcast_app.GET_GENRE_LIST
import com.mhst.padc_podcast_app.GET_RANDOM_PODCAST
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.network.responses.GenreResponse
import com.mhst.padc_podcast_app.network.responses.RandomPodcastResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Moe Htet on 05,September,2020
 */
interface PodcastApi {

    @GET(GET_RANDOM_PODCAST)
    fun getRandomPodcast() : Observable<RandomPodcastResponse>

    @GET(GET_GENRE_LIST)
    fun getGenres(@Query("genres")top_level_only : Int = 0) : Observable<GenreResponse>

}