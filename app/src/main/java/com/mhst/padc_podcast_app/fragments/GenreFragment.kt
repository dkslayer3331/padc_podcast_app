package com.mhst.padc_podcast_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.adapters.GenreAdapter
import com.mhst.padc_podcast_app.data.dummy.DummyDataUtils
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.mvp.presenters.GenrePresenter
import com.mhst.padc_podcast_app.mvp.view.GenreView
import kotlinx.android.synthetic.main.fragment_genre.*


/**
 * A simple [Fragment] subclass.
 * Use the [GenreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

//this is genre fragment :3
class GenreFragment : Fragment(),GenreView {

    lateinit var genreAdapter: GenreAdapter

    lateinit var genrePresenter: GenrePresenter

    private fun setupPresenter(){
       // genrePresenter = ViewModelProvider(this).get(GenrePresenter::class.java)
    }

    private fun setupRecycler(){
        genreAdapter = GenreAdapter()
        rvGenres.adapter = genreAdapter
        genreAdapter.setNewData(DummyDataUtils.getDummys())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_genre, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecycler()
    }

    companion object {
        @JvmStatic
        fun newInstance() = GenreFragment()
    }

    override fun displayGenres(genres: List<GenreVO>) {

    }

    override fun enableSwipeRefresh() {

    }

    override fun disableSwipeRefresh() {

    }
}