package com.mhst.padc_podcast_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.adapters.UpNextAdapter
import com.mhst.padc_podcast_app.data.DummyDataUtils
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var upNextAdapter: UpNextAdapter

    private fun setupRecycler(){
        upNextAdapter = UpNextAdapter()
        rvUpNext.adapter = upNextAdapter
        upNextAdapter.setNewData(DummyDataUtils.getDummys())
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
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}