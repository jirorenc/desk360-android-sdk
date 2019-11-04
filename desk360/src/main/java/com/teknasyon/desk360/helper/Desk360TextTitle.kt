package com.teknasyon.desk360.helper

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.TextView
import com.teknasyon.desk360.helper.Desk360Constants.currentTheme

class Desk360TextTitle : TextView {
    init {
         if (currentTheme == 1) {
            this.setBackgroundColor(Color.WHITE)
            this.setTextColor(Color.parseColor("#de000000"))
        } else {
            this.setBackgroundColor(Color.parseColor("#2b2b2b"))
            this.setTextColor(Color.parseColor("#ffffff"))
        }
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)
}