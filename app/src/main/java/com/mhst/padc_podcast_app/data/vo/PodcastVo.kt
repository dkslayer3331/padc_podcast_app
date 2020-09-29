package com.mhst.padc_podcast_app.data.vo

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.mhst.padc_podcast_app.persistance.typedConverters.PodcastConverter

@TypeConverters(PodcastConverter::class)
data class PodcastVo(

	@SerializedName("image")
	var image: String = "",

	@SerializedName("thumbnail")
	var thumbnail: String = "",

	@SerializedName("publisher")
	var publisher: String = "",

	@SerializedName("id")
	var id: String = "",

	@SerializedName("title")
	var title: String = "",

	@SerializedName("listennotes_url")
	var listenNotesUrl: String = ""
)
