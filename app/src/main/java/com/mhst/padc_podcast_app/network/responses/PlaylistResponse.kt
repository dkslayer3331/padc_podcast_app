package com.mhst.padc_podcast_app.network.responses

import com.google.gson.annotations.SerializedName
import com.mhst.padc_podcast_app.data.vo.ItemVo

data class PlaylistResponse(

	@SerializedName("total")
	val total: Int? = null,

	@SerializedName("visibility")
	val visibility: String? = null,

	@SerializedName("last_timestamp_ms")
	val lastTimestampMs: Long? = null,

	@SerializedName("type")
	val type: String? = null,

	@SerializedName("items")
	var items : List<ItemVo> = listOf()

)
