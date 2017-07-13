package com.adgvcxz.extension

import android.content.Context
import android.util.TypedValue

/**
 * zhaowei
 * Created by zhaowei on 2017/7/13.
 */
val Context.actionBarHeight: Int
    get() {
        val typedValue = TypedValue()
        if (theme.resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, resources.displayMetrics)
        }
        return resources.getDimensionPixelSize(R.dimen.action_bar_size)
    }

val Context.statusBarHeight: Int
    get() {
        val id = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (id > 0) {
            return resources.getDimensionPixelSize(id)
        }
        return resources.getDimensionPixelSize(R.dimen.status_bar_height)
    }