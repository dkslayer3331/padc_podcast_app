package com.mhst.padc_podcast_app.network.responses

import com.google.gson.annotations.SerializedName
import com.mhst.padc_podcast_app.data.vo.GenreVO

/**
 * Created by Moe Htet on 05,September,2020
 */
data class GenreResponse(
    @SerializedName("genres")
    var genres : List<GenreVO> = listOf()
)