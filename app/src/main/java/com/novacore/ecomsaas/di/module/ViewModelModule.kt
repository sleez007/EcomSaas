package com.novacore.ecomsaas.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.novacore.ecomsaas.di.annotation.ViewModelKey
import com.novacore.ecomsaas.helper.ViewModelProviderFactory
import com.novacore.ecomsaas.ui.cart.CartViewModel
import com.novacore.ecomsaas.ui.category.CategoryViewModel
import com.novacore.ecomsaas.ui.favorites.FavoriteViewModel
import com.novacore.ecomsaas.ui.home.HomeViewModel
import com.novacore.ecomsaas.ui.splash.SplashViewModel
import com.novacore.ecomsaas.ui.wizard.WizardViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashVm(vm : SplashViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WizardViewModel::class)
    abstract fun bindWizardVm(vm : WizardViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeVm(vm : HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    abstract fun bindcartVm(vm : CartViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun bindFavoriteVm(vm : FavoriteViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    abstract fun bindCategoryVm(vm : CategoryViewModel) : ViewModel
}