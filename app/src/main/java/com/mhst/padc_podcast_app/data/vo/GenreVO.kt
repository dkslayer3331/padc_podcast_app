package com.mhst.padc_podcast_app.data.vo

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.mhst.padc_podcast_app.persistance.typedConverters.GenreTypedConverter

/**
 * Created by Moe Htet on 05,September,2020
 */
data class GenreVO(
    @SerializedName("id")
    var id : Long = 0L,
    @SerializedName("parent_id")
    var parentId : Long = 0L,
    @SerializedName("name")
    var name : String = ""
)