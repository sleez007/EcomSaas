package com.novacore.ecomsaas.helper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/*
 * @author: Etoka kingsley
 * THIS CLASS IS A BOILER PLATE CODE AND CAN BE COPIED OVER TO OTHER PROJECT AND IS SUITABLE FOR DI
 */
class ViewModelProviderFactory @Inject constructor(
    private val creators: @JvmSuppressWildcards Map<Class<out ViewModel>,
            Provider<ViewModel>>): ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator : Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }

        if (creator == null) {
            throw IllegalArgumentException("Unknown model class: $modelClass")
        }
        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}