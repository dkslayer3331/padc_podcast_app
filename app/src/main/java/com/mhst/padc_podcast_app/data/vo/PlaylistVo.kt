package com.mhst.padc_podcast_app.data.vo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Moe Htet on 06,September,2020
 */
data class PlaylistVo(
    @SerializedName("id")
    var id : Int = 0,
    @SerializedName("type")
    var type : String = "",
    @SerializedName("notes")
    var notes : String = "",
    @SerializedName("data")
    val data : DataVo = DataVo(),
    @SerializedName("added_at_ms")
    var addedAtMs : Long = 0L
)