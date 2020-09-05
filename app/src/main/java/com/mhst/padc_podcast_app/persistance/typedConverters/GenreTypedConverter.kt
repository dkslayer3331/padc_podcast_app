package com.mhst.padc_podcast_app.persistance.typedConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mhst.padc_podcast_app.data.vo.GenreVO

/**
 * Created by Moe Htet on 05,September,2020
 */

class GenreTypedConverter {

    @TypeConverter
    fun toString(list : List<GenreVO>) : String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(genreStr : String) : List<String>{
        val genres = object : TypeToken<ArrayList<GenreVO>>() {}.type
        return Gson().fromJson(genreStr, genres)
    }

}