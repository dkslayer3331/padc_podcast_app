package com.mhst.padc_podcast_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.adapters.GenreAdapter
import com.mhst.padc_podcast_app.data.DummyDataUtils
import kotlinx.android.synthetic.main.fragment_genre.*


/**
 * A simple [Fragment] subclass.
 * Use the [GenreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

//this is genre fragment :3
class GenreFragment : Fragment() {

    lateinit var genreAdapter: GenreAdapter

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
}