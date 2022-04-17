package com.presentation.daggerplayground.di

import android.content.Context
import com.presentation.daggerplayground.BuildConfig
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
object PicassoModule {

    @Provides
    @Singleton
    fun provideOkhttp3Downloader(okHttpClient: OkHttpClient): OkHttp3Downloader {
        return OkHttp3Downloader(okHttpClient)
    }

    @Provides
    @Singleton
    fun providePicasso(context: Context, okHttpDownloader: OkHttp3Downloader): Picasso {
        return Picasso.Builder(context)
            .loggingEnabled(BuildConfig.DEBUG)
            .downloader(okHttpDownloader)
            .build()
    }
}
