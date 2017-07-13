package com.adgvcxz.extension

import android.view.View
import android.view.ViewTreeObserver

/**
 * zhaowei
 * Created by zhaowei on 2017/7/13.
 */

inline fun <T: View> T.post(crossinline block: (T) -> Unit) {
    post { block(this) }
}

fun View.addOnLayoutListener(callback: () -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            viewTreeObserver.removeOnGlobalLayoutListener(this)
            callback()
        }
    })
}