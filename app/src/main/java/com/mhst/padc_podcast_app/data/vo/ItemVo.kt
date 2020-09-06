package com.mhst.padc_podcast_app.data.vo

import androidx.room.Entity
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.mhst.padc_podcast_app.persistance.typedConverters.DataVoConverter
import com.mhst.padc_podcast_app.persistance.typedConverters.PlayTrackConverter

/**
 * Created by Moe Htet on 06,September,2020
 */
@Entity(tableName = "playlists")
@TypeConverters(DataVoConverter::class,PlayTrackConverter::class)
data class ItemVo(
    @SerializedName("id")
    val id : Int,
    @SerializedName("type")
    var type : String = "",
    @SerializedName("notes")
    var notes : String = "",
    @SerializedName("data")
    val data : DataVo? = null,
    @SerializedName("added_at_ms")
    var addedAtMs : Long = 0L
)