package com.mhst.padc_podcast_app.persistance.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mhst.padc_podcast_app.data.vo.DataVo
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.data.vo.PodcastVo
import com.mhst.padc_podcast_app.persistance.dao.GenreDao

/**
 * Created by Moe Htet on 05,September,2020
 */
@Database(entities = [GenreVO::class,DataVo::class,PlaylistVo::class,PodcastVo::class], version = 7, exportSchema = false)
//@TypeConverters(PodcastConverter::class,DataVoConverter::class,ItemVoConverter::class)
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

}