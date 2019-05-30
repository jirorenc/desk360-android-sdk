package com.teknasyon.desk360.helper

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.TextView
import com.teknasyon.desk360.helper.AresConstants.currentTheme

class Desk360TextSendMessage : TextView {
    init {
        if (currentTheme == "light") {
            this.setBackgroundColor(Color.WHITE)
            this.setTextColor(Color.parseColor("#ffffff"))
        } else {
            this.setBackgroundColor(Color.parseColor("#5b5b5b"))
            this.setTextColor(Color.parseColor("#000000"))
        }
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)
}