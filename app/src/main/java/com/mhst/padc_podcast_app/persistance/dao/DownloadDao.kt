package com.mhst.padc_podcast_app.persistance.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mhst.padc_podcast_app.data.vo.DownloadVO

/**
 * Created by Moe Htet on 01,October,2020
 */
@Dao
interface DownloadDao {

    @Query("select * from downloads")
    fun getAllDownloads() : LiveData<List<DownloadVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDownload(downloadVO: DownloadVO)

    @Query("delete from downloads")
    fun deleteAll()

}