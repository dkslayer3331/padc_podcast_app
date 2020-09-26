package com.mhst.padc_podcast_app.data.vo

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

data class DataVo(

	@SerializedName("image")
	val image: String? = null,

	@SerializedName("thumbnail")
	val thumbnail: String? = null,

	@SerializedName("explicit_content")
	val explicitContent: Boolean? = null,

	@field:SerializedName("listennotes_edit_url")
	val listennotesEditUrl: String? = null,

	@field:SerializedName("audio_length_sec")
	val audioLengthSec: Int? = null,

	@SerializedName("link")
	val link: String? = null,

	@SerializedName("description")
	val description: String? = null,

	@SerializedName("title")
	val title: String? = null,

	@SerializedName("listennotes_url")
	val listennotesUrl: String? = null,

	@SerializedName("audio")
	val audio: String? = null,

	@PrimaryKey
	@SerializedName("id")
	val id: String,

	@SerializedName("pub_date_ms")
	val pubDateMs: Long? = null,

	@SerializedName("maybe_audio_invalid")
	val maybeAudioInvalid: Boolean? = null,

	@SerializedName("podcast")
	val podcast : PodcastVo

)
