package com.example.test.utils

import android.app.Application
import com.example.test.local.AppDatabase

class App: Application() {
    companion object{
        lateinit var database : AppDatabase
        private set
    }

    override fun onCreate() {
        super.onCreate()

        database = AppDatabase.getAppDatabase(applicationContext)
    }

}