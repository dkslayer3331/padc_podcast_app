package com.mhst.padc_podcast_app.persistance.typedConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mhst.padc_podcast_app.data.vo.DataVo

/**
 * Created by Moe Htet on 06,September,2020
 */
class DataVoConverter{

    @TypeConverter
    fun toString(list : List<DataVo>) : String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(playlist : String) : List<String>{
        val type = object : TypeToken<ArrayList<DataVo>>() {}.type
        return Gson().fromJson(playlist, type)
    }

}