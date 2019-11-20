package com.teknasyon.desk360.themev2

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.DisplayMetrics
import androidx.constraintlayout.widget.ConstraintLayout
import com.teknasyon.desk360.helper.Desk360Constants.currentType

class Desk360TicketListEmptyButton : ConstraintLayout {
    private val gradientDrawable = GradientDrawable()

    init {
        gradientDrawable.setColor(Color.parseColor(currentType?.data?.ticket_list_screen?.empty_button_background_color))
        gradientDrawable.setStroke(
            1,
            Color.parseColor(currentType?.data?.ticket_list_screen?.empty_button_border_color)
        )


        //TODO sabir
        when (currentType?.data?.ticket_list_screen?.empty_button_style_id) {
            1 -> {
                gradientDrawable.cornerRadius = convertDpToPixel(28f, context)
            }
            2 -> {
                gradientDrawable.cornerRadius = convertDpToPixel(0f, context)
            }
            3 -> {
                gradientDrawable.cornerRadius = convertDpToPixel(10f, context)
            }
            4 -> {
                gradientDrawable.cornerRadius = convertDpToPixel(2f, context)
            }
            5 -> {
                gradientDrawable.cornerRadius = convertDpToPixel(10f, context)
            }
            else -> {
                gradientDrawable.cornerRadius = convertDpToPixel(28f, context)
            }
        }

        this.background = gradientDrawable
    }

    private fun convertDpToPixel(dp: Float, context: Context): Float {
        return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )
}