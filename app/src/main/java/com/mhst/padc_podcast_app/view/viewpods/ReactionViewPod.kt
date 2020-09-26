package com.mhst.padc_podcast_app.view.viewpods

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.viewpod_reaction.view.*

/**
 * Created by Moe Htet on 26,September,2020
 */
class ReactionViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun bindData(duration : String,text1 : String,text2 : String){
        tvDuration.text = duration
        tvReactionTextOne.text = text1
        tvReactionTextTwo.text = text2
    }

}