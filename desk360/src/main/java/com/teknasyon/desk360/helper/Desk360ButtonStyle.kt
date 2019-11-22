package com.teknasyon.desk360.helper

import android.content.Context
import android.util.DisplayMetrics
import androidx.constraintlayout.widget.ConstraintLayout

object Desk360ButtonStyle {

    fun setStyle(styleId : Int?,layout: ConstraintLayout,context: Context) {
        val params = layout.layoutParams as ConstraintLayout.LayoutParams
        when (styleId) {
            1,3,4,5-> {
                params.setMargins(convertDpToPixel(32f,context).toInt(), 0, convertDpToPixel(32f,context).toInt(), 0)
            }
            2 -> {
                params.setMargins(0, 0, 0, 0)
            }
            else -> {
                params.setMargins(convertDpToPixel(32f,context).toInt(), 0, convertDpToPixel(32f,context).toInt(), 0)
            }
        }

        layout.layoutParams = params
    }

    private fun convertDpToPixel(dpOfMargin: Float, context: Context): Float {
        return dpOfMargin * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
}