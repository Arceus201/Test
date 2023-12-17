package com.example.test.utils

import android.os.Handler
import android.os.Looper

object Constant {
    const val URL_GOOGLE = "https://www.google.com/"
    const val URL_STACK_OVER_FLOW = "https://stackoverflow.com/"
    val handler = Handler(Looper.getMainLooper())
    const val TIME_DELAY_START_APP = 1000L
}