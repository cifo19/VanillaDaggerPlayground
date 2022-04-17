package com.presentation.daggerplayground.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.presentation.daggerplayground.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val OK_HTTP_CONNECTION_TIME_OUT = 15000L
private const val OK_HTTP_READ_TIME_OUT = 15000L
private const val OK_HTTP_WRITE_TIME_OUT = 15000L

@Module
object NetworkModule {

    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun providesRetrofitGsonFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(OK_HTTP_CONNECTION_TIME_OUT, TimeUnit.MILLISECONDS)
            .readTimeout(OK_HTTP_READ_TIME_OUT, TimeUnit.MILLISECONDS)
            .writeTimeout(OK_HTTP_WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }
}
