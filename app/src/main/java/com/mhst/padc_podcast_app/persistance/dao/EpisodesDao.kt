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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(list : List<PodcastWrapperVo>)

    @Query("delete from episodes")
    fun delteAllEpisodes()

    @Query("select * from episodes order by random() LIMIT 1")
    fun getRandom() : PodcastWrapperVo

    @Query("select * from episodes where id =:id")
    fun getDetail(id : String) : PodcastWrapperVo

}