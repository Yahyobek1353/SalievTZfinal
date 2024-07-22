package com.myself223.graduationtestassignment

import android.app.Application
import com.myself223.data.module.networkModule
import com.myself223.data.module.repoModule
import com.myself223.domain.module.useCaseModule
import com.myself223.main.presentation.module.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GraduationTestAssignment : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GraduationTestAssignment)
            modules(networkModule, repoModule, useCaseModule, uiModule)
        }
    }
}
