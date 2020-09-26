package com.mhst.padc_podcast_app.network.responses

import com.google.gson.annotations.SerializedName
import com.mhst.padc_podcast_app.data.vo.PlaylistVo

data class PlaylistResponse(

	@SerializedName("id")
	val id : String = "",

	@SerializedName("name")
	val name : String = "",

	@SerializedName("type")
	val type: String? = null,

	@SerializedName("items")
	var items : List<PlaylistVo> = listOf()

)
