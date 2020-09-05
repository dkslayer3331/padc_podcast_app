package com.mhst.padc_podcast_app.data.dummy

/**
 * Created by Moe Htet on 03,September,2020
 */
object DummyDataUtils {

    val dummyData = mutableListOf<DummyVo>()

    fun getDummys() : MutableList<DummyVo> {
        for(i in 1..5){
            dummyData.add(
                DummyVo()
            )
        }
        return dummyData
    }


}