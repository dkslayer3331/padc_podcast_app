package com.mhst.padc_podcast_app.data.vo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Moe Htet on 05,September,2020
 */
@Entity(tableName = "genres")
data class GenreVO(
    @PrimaryKey
    @SerializedName("id")
    var id : String = "",
    @SerializedName("parent_id")
    var parentId : String = "",
    @SerializedName("name")
    var name : String = ""
)