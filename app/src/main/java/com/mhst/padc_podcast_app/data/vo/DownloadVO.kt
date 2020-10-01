package com.mhst.padc_podcast_app.data.vo

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.mhst.padc_podcast_app.persistance.typedConverters.PodcastWapperTypeConverter

/**
 * Created by Moe Htet on 01,October,2020
 */
@Entity(tableName = "downloads")
@TypeConverters(PodcastWapperTypeConverter::class)
data class DownloadVO(
    @PrimaryKey
    var id : String = "",
    var podcast : PodcastWrapperVo = PodcastWrapperVo()
)