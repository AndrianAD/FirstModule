package com.android.pickerfoto

import android.app.Activity
import android.content.Intent

class StartPicker(var activity: Activity, var type: String, var key:Int) {

    fun startPicker() {
        val intent = Intent(activity, PickerActivity::class.java)
        intent.putExtra(STRING_EXTRA, type)
        activity.startActivityForResult(intent, key)
    }
}