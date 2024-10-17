package org.example.di

import org.example.api.HttpSource
import org.example.api.MegaVerseApi
import org.example.api.MegaVerseApiImpl
import org.koin.dsl.module

val networkModule = module {
    single { HttpSource() }
    single<MegaVerseApi> { MegaVerseApiImpl(get<HttpSource>()) }
}