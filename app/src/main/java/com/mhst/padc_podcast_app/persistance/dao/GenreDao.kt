package com.mhst.padc_podcast_app.persistance.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mhst.padc_podcast_app.data.vo.GenreVO

/**
 * Created by Moe Htet on 05,September,2020
 */
@Dao
interface GenreDao {
    @Query("select * from genres")
    fun getAllGenres() : LiveData<List<GenreVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGenres(movies : List<GenreVO>)

    @Query("delete from genres")
    fun deleteAllGeneres()

    @Transaction
    fun deleteInsert(genres: List<GenreVO>){
        deleteAllGeneres()
        addGenres(genres)
    }
}