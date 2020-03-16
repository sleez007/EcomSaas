package com.novacore.ecomsaas.di.module

import com.novacore.ecomsaas.di.annotation.FragmentScope
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
    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun splashFragment() : SplashFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun wizardFragment() : Wizard

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun homeFragment() : HomeFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun categoryFragment() : CategoryFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun cartFragment() : CartFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun favoriteFragment() : FavoriteFragment

}