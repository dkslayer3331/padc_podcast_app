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
    fun toString(list : List<PodcastVo>) : String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(jsonStr : String) : List<String>{
        val podcasts = object : TypeToken<ArrayList<PodcastVo>>() {}.type
        return Gson().fromJson(jsonStr, podcasts)
    }

}