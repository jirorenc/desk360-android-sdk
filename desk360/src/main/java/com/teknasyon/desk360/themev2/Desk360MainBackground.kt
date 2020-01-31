package com.teknasyon.desk360.themev2

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.teknasyon.desk360.helper.Desk360Constants


class Desk360MainBackground : ConstraintLayout {

    init {

        try {
            this.setBackgroundColor(Color.parseColor(Desk360Constants.currentType?.data?.general_settings?.main_background_color))
        } catch (e: Exception) {
            this.setBackgroundColor(Color.parseColor("#F7F7F7"))
        }
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )
}