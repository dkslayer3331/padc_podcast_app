package com.mhst.padc_podcast_app.activities

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.exoplayer2.offline.Download
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.fragments.DownloadFragment
import com.mhst.padc_podcast_app.fragments.GenreFragment
import com.mhst.padc_podcast_app.fragments.HomeFragment
import com.mhst.padc_podcast_app.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val genreFragment = GenreFragment()
    private val downloadFragment = DownloadFragment()
    private val profileFragment = ProfileFragment()
    var active = homeFragment
    val fm = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm.beginTransaction().add(R.id.main_container,downloadFragment,"download").hide(downloadFragment).commit()
        fm.beginTransaction().add(R.id.main_container,genreFragment,"genre").hide(genreFragment).commit()
        fm.beginTransaction().add(R.id.main_container,profileFragment,"profile").hide(profileFragment).commit()
        fm.beginTransaction().add(R.id.main_container,homeFragment,"home").commit()

        nav_view.setOnNavigationItemSelectedListener(object  : )


//        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//
//        val navController = findNavController(R.id.nav_host_fragment)
//        val appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.navigation_home,
//            R.id.navigation_search,
//            R.id.navigation_download
//        ))
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)


    }
}