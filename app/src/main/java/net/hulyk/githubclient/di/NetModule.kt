package com.toastme.di

import com.fasterxml.jackson.databind.ObjectMapper
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import net.hulyk.githubclient.BuildConfig.DEBUG
import net.hulyk.githubclient.service.APIService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import okhttp3.logging.LoggingEventListener
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(if (DEBUG) BODY else NONE)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) =
            OkHttpClient.Builder()
                    .pingInterval(1, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .eventListenerFactory(LoggingEventListener.Factory())
                    .build()

    @Provides
    @Singleton
    fun provideJacksonConverterFactory(objectMapper: ObjectMapper): JacksonConverterFactory {
        return JacksonConverterFactory.create(objectMapper)
    }

    @Provides
    @Singleton
    @Named("rx")
    fun provideRxJava2CallAdapterFactory(): CallAdapter.Factory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    @Named("coroutine")
    fun provideCoroutineCallAdapterFactory(): CallAdapter.Factory {
        return CoroutineCallAdapterFactory()
    }

    @Provides
    @Singleton
    @Named("serverUrl")
    fun provideServerUrl(): String {
        return "https://api.github.com"
    }

    @Provides
    @Singleton
    fun provideAuthorizedRetrofit(
            jacksonConverterFactory: JacksonConverterFactory,
            @Named("coroutine") callAdapterFactory: CallAdapter.Factory,
            okHttpClient: OkHttpClient,
            @Named("serverUrl") serverUrl: String
    ): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(jacksonConverterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .baseUrl(serverUrl)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideAPIService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }

}