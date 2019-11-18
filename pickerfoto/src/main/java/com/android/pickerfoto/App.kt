package com.android.pickerfoto

import android.app.Application
import android.content.Context

val Context.myApp: App get() = applicationContext as App
const val TYPE = "TYPE"

class App : Application() {

    companion object {
        var selectedImage = mutableListOf<File>()
    }


    override fun onCreate() {
        super.onCreate()

    }
}