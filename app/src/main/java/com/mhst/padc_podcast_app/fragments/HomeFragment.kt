package com.mhst.padc_podcast_app.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.adapters.UpNextAdapter
import com.mhst.padc_podcast_app.data.dummy.DummyDataUtils
import com.mhst.padc_podcast_app.data.vo.ItemVo
import com.mhst.padc_podcast_app.mvp.presenters.HomePresenter
import com.mhst.padc_podcast_app.mvp.presenters.HomePresenterImpl
import com.mhst.padc_podcast_app.mvp.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),HomeView {

    private lateinit var upNextAdapter: UpNextAdapter

    private lateinit var homePresenter: HomePresenter

    private fun setupRecycler(){
        upNextAdapter = UpNextAdapter()
        rvUpNext.adapter = upNextAdapter
        upNextAdapter.setNewData(DummyDataUtils.getDummys())
    }

    private fun setupPresenter(){
        homePresenter = ViewModelProvider(this).get(HomePresenterImpl::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecycler()
        setupPresenter()
        homePresenter.onUiReady(this)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun displayTracks(tracks: List<ItemVo>) {
        Log.d("tracks",tracks.size.toString())
    }

    override fun enableSwipeRefresh() {

    }

    override fun disableSwipeRefresh() {

    }
}