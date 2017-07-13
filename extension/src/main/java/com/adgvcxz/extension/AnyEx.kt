package com.adgvcxz.extension

import android.os.Looper

/**
 * zhaowei
 * Created by zhaowei on 2017/7/13.
 */
fun ensureChangeOnMainThread() {
    if (Thread.currentThread() != Looper.getMainLooper().thread) {
        throw IllegalStateException("You must only modify the ObservableList on the main thread.")
    }
}