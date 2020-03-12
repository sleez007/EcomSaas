package com.novacore.ecomsaas.di.module

import com.novacore.ecomsaas.ui.cart.CartFragment
import com.novacore.ecomsaas.ui.category.CategoryFragment
import com.novacore.ecomsaas.ui.favorites.FavoriteFragment
import com.novacore.ecomsaas.ui.home.HomeFragment
import com.novacore.ecomsaas.ui.splash.SplashFragment
import com.novacore.ecomsaas.ui.wizard.Wizard
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    internal abstract fun splashFragment() : SplashFragment

    @ContributesAndroidInjector
    internal abstract fun wizardFragment() : Wizard

    @ContributesAndroidInjector
    internal abstract fun homeFragment() : HomeFragment

    @ContributesAndroidInjector
    internal abstract fun categoryFragment() : CategoryFragment

    @ContributesAndroidInjector
    internal abstract fun cartFragment() : CartFragment

    @ContributesAndroidInjector
    internal abstract fun favoriteFragment() : FavoriteFragment

}