package com.mhst.padc_podcast_app.persistance.typedConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mhst.padc_podcast_app.data.vo.DataVo
import com.mhst.padc_podcast_app.data.vo.ItemVo

/**
 * Created by Moe Htet on 06,September,2020
 */
class PlayTrackConverter {

    @TypeConverter
    fun toString(list : List<ItemVo>) : String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(playlist : String) : List<String>{
        val type = object : TypeToken<ArrayList<ItemVo>>() {}.type
        return Gson().fromJson(playlist, type)
    }


}