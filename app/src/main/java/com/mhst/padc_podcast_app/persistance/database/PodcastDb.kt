package com.mhst.padc_podcast_app.persistance.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mhst.padc_podcast_app.data.vo.DownloadVO
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.persistance.dao.DownloadDao
import com.mhst.padc_podcast_app.persistance.dao.EpisodesDao
import com.mhst.padc_podcast_app.persistance.dao.GenreDao
import com.mhst.padc_podcast_app.persistance.typedConverters.PodcastConverter

/**
 * Created by Moe Htet on 05,September,2020
 */
@Database(entities = [GenreVO::class,PodcastWrapperVo::class,DownloadVO::class], version = 8, exportSchema = false)
@TypeConverters(PodcastConverter::class)
abstract class PodcastDb : RoomDatabase() {
    companion object {
        val DB_NAME = "PADC_PODCAST.DB"
        var dbInstance: PodcastDb? = null

        fun getDBInstance(context: Context): PodcastDb {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, PodcastDb::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }

    }

    abstract fun genreDao() : GenreDao

    abstract fun episodeDao() : EpisodesDao

    abstract fun downloadDao() : DownloadDao

}