package com.mhst.padc_podcast_app.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.network.responses.PlaylistResponse
import com.mhst.padc_podcast_app.network.responses.RandomPodcastResponse

/**
 * Created by Moe Htet on 27,September,2020
 */
object PodcastImpl : PodCastFirebaseApi {

    private val database: DatabaseReference = Firebase.database.reference

    override fun getRandomPodcast(
        onSuccess: (PodcastWrapperVo) -> Unit,
        onFail: (String) -> Unit
    ) {
        database.child("latest_episodes").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                onFail(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<PodcastWrapperVo>()
                snapshot.children.forEach{
                    it.getValue(PodcastWrapperVo::class.java)?.let {
                        list.add(it)
                    }
                    onSuccess(list.random())
                }
            }

        })
    }

    override fun getPlayList(onSuccess: (List<PodcastWrapperVo>) -> Unit,
        onFail: (String) -> Unit
    ) {
        database.child("latest_episodes").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                onFail(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<PodcastWrapperVo>()
                snapshot.children.forEach{
                    it.getValue(PodcastWrapperVo::class.java)?.let {
                        list.add(it)
                    }
                    onSuccess(list)
                }
            }

        })
    }

    override fun getGenres(onSuccess: (List<GenreVO>) -> Unit, onFail: (String) -> Unit) {
        database.child("genres").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                onFail(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
               val list = mutableListOf<GenreVO>()
                snapshot.children.forEach {
                    it.getValue(GenreVO::class.java)?.let {
                        list.add(it)
                    }
                }
                onSuccess(list.toList())
            }
        })
    }
}