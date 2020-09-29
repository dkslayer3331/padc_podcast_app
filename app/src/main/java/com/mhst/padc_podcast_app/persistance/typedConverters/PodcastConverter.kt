package com.mhst.padc_podcast_app.persistance.typedConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mhst.padc_podcast_app.data.vo.PodcastVo

/**
 * Created by Moe Htet on 29,September,2020
 */

class PodcastConverter {

    @TypeConverter
    fun toString(podcast : PodcastVo) : String{
        return Gson().toJson(podcast)
    }

    @TypeConverter
    fun toObj(jsonStr : String) : PodcastVo{
        val podcast = object : TypeToken<PodcastVo>() {}.type
        return Gson().fromJson(jsonStr, podcast)
    }

}