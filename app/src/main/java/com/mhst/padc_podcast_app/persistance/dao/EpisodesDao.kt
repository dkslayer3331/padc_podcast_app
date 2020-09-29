package com.mhst.padc_podcast_app.persistance.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import retrofit2.http.GET

/**
 * Created by Moe Htet on 29,September,2020
 */
@Dao
interface EpisodesDao {

    @Query("select * from episodes")
    fun getAllEpisodes() : LiveData<List<PodcastWrapperVo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisode(podcastWrapperVo: PodcastWrapperVo)

    @Query("delete from episodes")
    fun delteAllEpisodes()

}