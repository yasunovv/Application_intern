package com.yasunov.myapplication

import android.app.Application
import android.content.Context

class App: Application() {


}

val Context.app: App
    get() = when (this) {
        is App -> App()
        else -> (applicationContext as App)
    }