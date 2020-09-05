package com.mhst.padc_podcast_app.network.responses

import com.google.gson.annotations.SerializedName
import com.mhst.padc_podcast_app.data.vo.PodcastVo

data class RandomPodcastResponse(

	@SerializedName("image")
	val image: String? = null,

	@SerializedName("thumbnail")
	val thumbnail: String? = null,

	@SerializedName("explicit_content")
	val explicitContent: Boolean? = null,

	@SerializedName("listennotes_edit_url")
	val listennotesEditUrl: String? = null,

	@SerializedName("audio_length_sec")
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

	@SerializedName("id")
	val id: String? = null,

	@SerializedName("pub_date_ms")
	val pubDateMs: Long? = null,

	@SerializedName("maybe_audio_invalid")
	val maybeAudioInvalid: Boolean? = null,

	@SerializedName("podcast")
	var podcast : PodcastVo? = null

)
