package com.mhst.padc_podcast_app.data.vo

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

data class PodcastWrapperVo(

	@SerializedName("image")
	var image: String = "",

	@SerializedName("thumbnail")
	var thumbnail: String = "",

	@SerializedName("explicit_content")
	var explicitContent: Boolean = false,

	@field:SerializedName("listennotes_edit_url")
	var listennotesEditUrl: String = "",

	@field:SerializedName("audio_length_sec")
	val audioLengthSec: Int = 0,

	@SerializedName("link")
	var link: String = "",

	@SerializedName("description")
	var description: String = "",

	@SerializedName("title")
	var title: String = "",

	@SerializedName("listennotes_url")
	var listennotesUrl: String = "",

	@SerializedName("audio")
	var audio: String = "",

	@SerializedName("id")
	var id: String = "",

	@SerializedName("pub_date_ms")
	var pubDateMs: Long = 0L,

	@SerializedName("maybe_audio_invalid")
	var maybeAudioInvalid: Boolean = false,

	@SerializedName("podcast")
	var podcast : PodcastVo = PodcastVo()

)
