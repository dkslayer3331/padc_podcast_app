package com.mhst.padc_podcast_app.persistance.typedConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mhst.padc_podcast_app.data.vo.PodcastVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo

/**
 * Created by Moe Htet on 01,October,2020
 */
class PodcastWapperTypeConverter {

    @TypeConverter
    fun toJsonStr(podcastWrapperVo: PodcastWrapperVo) : String{
        return Gson().toJson(podcastWrapperVo)
    }

    @TypeConverter
    fun toObj(jsonStr : String) : PodcastWrapperVo{
        val podcast = object : TypeToken<PodcastWrapperVo>() {}.type
        return Gson().fromJson(jsonStr, podcast)
    }

}