package com.mhst.padc_podcast_app.persistance.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mhst.padc_podcast_app.data.vo.GenreVO

/**
 * Created by Moe Htet on 05,September,2020
 */
@Database(entities = [GenreVO::class], version = 1, exportSchema = false)
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

        //todo : add daos here

    }


}