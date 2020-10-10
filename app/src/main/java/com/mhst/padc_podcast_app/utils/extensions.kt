package com.mhst.padc_podcast_app.utils

import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.PodcastVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo

/**
 * Created by Moe Htet on 10,October,2020
 */

fun Map<String,Any>?.toGenre() : GenreVO {
    return GenreVO(
        id = this?.get("id") as Long,
        name = this?.get("name") as String,
        parentId = this?.get("parent_id") as Long
    )
}

fun Map<String,Any>?.toPodcast() : PodcastWrapperVo{
    val podcastWrapperVo = PodcastWrapperVo()
    podcastWrapperVo.id = this?.get("id") as String
    podcastWrapperVo.maybeAudioInvalid = this?.get("maybe_audio_invalid") as Boolean
    podcastWrapperVo.pubDateMs = this?.get("pub_date_ms") as Long
    podcastWrapperVo.audio = this?.get("audio") as String
    podcastWrapperVo.listennotesUrl = this?.get("listennotes_url") as String
    podcastWrapperVo.title = this?.get("title") as String
    podcastWrapperVo.description = this?.get("description") as String
    podcastWrapperVo.link = this?.get("link") as String
    podcastWrapperVo.audioLengthSec = (this?.get("audio_length_sec") as Long).toInt()
    podcastWrapperVo.listennotesEditUrl = this?.get("listennotes_edit_url") as String
    podcastWrapperVo.explicitContent = this?.get("explicit_content") as Boolean
    podcastWrapperVo.thumbnail = this?.get("thumbnail") as String
    podcastWrapperVo.image = this?.get("image") as String
    val podcast = this?.get("podcast") as Map<String,Any>
    podcastWrapperVo.podcast = PodcastVo(
        image = podcast["image"] as String,
        id = podcast["id"] as String,
        thumbnail = podcast["thumbnail"] as String,
        publisher = podcast["publisher"] as String,
        listenNotesUrl = podcast["listennotes_url"] as String,
        title = podcast["title"] as String
    )
    return podcastWrapperVo
}