package com.mhst.padc_podcast_app.persistance.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mhst.padc_podcast_app.data.vo.ItemVo

/**
 * Created by Moe Htet on 06,September,2020
 */
@Dao
interface PlayListDao {

    @Query("select * from playlists")
    fun getAllTracks() : LiveData<List<ItemVo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTrack(tracks : List<ItemVo>)

    @Query("delete from playlists")
    fun deleteAllGeneres()

    @Transaction
    fun deleteInsert(list: List<ItemVo>){
        deleteAllGeneres()
        addTrack(list)
    }

}