package com.novacore.ecomsaas.network.interceptor

import okhttp3.Interceptor

//this is used in the di package to provide different implementation of parent interface
interface ConnectivityInterceptor : Interceptor