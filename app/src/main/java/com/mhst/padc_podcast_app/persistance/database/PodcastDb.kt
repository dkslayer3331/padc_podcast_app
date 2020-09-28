package com.mhst.padc_podcast_app.persistance.database

/**
 * Created by Moe Htet on 05,September,2020
 */
//@Database(entities = [], version = 7, exportSchema = false)
////@TypeConverters(PodcastConverter::class,DataVoConverter::class,ItemVoConverter::class)
//abstract class PodcastDb : RoomDatabase() {
//    companion object {
//        val DB_NAME = "PADC_PODCAST.DB"
//        var dbInstance: PodcastDb? = null
//
//        fun getDBInstance(context: Context): PodcastDb {
//            when (dbInstance) {
//                null -> {
//                    dbInstance = Room.databaseBuilder(context, PodcastDb::class.java, DB_NAME)
//                        .allowMainThreadQueries()
//                        .fallbackToDestructiveMigration()
//                        .build()
//                }
//            }
//
//            val i = dbInstance
//            return i!!
//        }
//
//    }
//
//   // abstract fun genreDao() : GenreDao
//
//}