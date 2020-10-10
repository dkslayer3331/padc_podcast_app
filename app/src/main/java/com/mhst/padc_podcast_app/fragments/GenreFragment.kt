package com.mhst.padc_podcast_app.fragments

import android.os.Bundle
import android.util.Log
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
import com.mhst.padc_podcast_app.mvp.presenters.impls.GenrePresenterImpl
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
        genrePresenter = ViewModelProvider(this).get(GenrePresenterImpl::class.java)
        genrePresenter.initPresenter(this)
    }

    private fun setupRecycler(){
        genreAdapter = GenreAdapter()
        rvGenres.adapter = genreAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_genre, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupPresenter()
        setupRecycler()
        genrePresenter.onUiReady(this)
        genreSwipeRefresh.setOnRefreshListener {
            genrePresenter.onSwipeRefresh(this)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = GenreFragment()
    }

    override fun displayGenres(genres: List<GenreVO>) {
        Log.d("genreSize",genres.size.toString())
        genreAdapter.setNewData(genres.toMutableList())
    }

    override fun displayLargeBanner(genreVO: GenreVO) {
        tvLargeBannerLabel.text = genreVO.name
    }

    override fun enableSwipeRefresh() {
        genreSwipeRefresh.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        genreSwipeRefresh.isRefreshing = false
    }

    override fun showError(message: String) {
        Log.d("genreErr",message)
    }
}