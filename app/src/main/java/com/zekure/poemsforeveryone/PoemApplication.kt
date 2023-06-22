package com.zekure.poemsforeveryone

import android.app.Application
import com.zekure.poemsforeveryone.data.AppContainer
import com.zekure.poemsforeveryone.data.DefaultAppContainer

class PoemApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}