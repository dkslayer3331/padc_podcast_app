package com.mhst.padc_podcast_app.data.vo

import com.google.gson.annotations.SerializedName

data class PodcastVo(

	@SerializedName("image")
	var image: String = "",

	@SerializedName("thumbnail")
	var thumbnail: String = "",

	@field:SerializedName("publisher")
	var publisher: String = "",

	@field:SerializedName("id")
	var id: String = "",

	@field:SerializedName("title")
	var title: String = "",

	@field:SerializedName("listennotes_url")
	var listenNotesUrl: String = ""
)
