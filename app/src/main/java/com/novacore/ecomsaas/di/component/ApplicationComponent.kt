package com.novacore.ecomsaas.di.component

import android.content.Context
import com.novacore.ecomsaas.EcomApp
import com.novacore.ecomsaas.di.module.FragmentModule
import com.novacore.ecomsaas.di.module.NetworkModule
import com.novacore.ecomsaas.di.module.RoomModule
import com.novacore.ecomsaas.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    RoomModule::class,
    FragmentModule::class,
    ViewModelModule::class
])
interface ApplicationComponent : AndroidInjector<EcomApp> {

    @Component.Factory
    interface  Factory{
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}