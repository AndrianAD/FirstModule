package com.android.pickerfoto

import android.app.Activity
import android.content.Intent

class StartPicker(var activity: Activity, var type: String, var key:Int) {

    fun startPicker(type: String) {
        val intent = Intent(activity, MainActivity::class.java)
        intent.putExtra(TYPE, type)
        activity.startActivityForResult(intent, key)
    }
}