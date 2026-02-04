package com.example.demo_scaff_snap.network

import com.example.demo_scaff_snap.dataStore.IPreferenceDataStoreAPI
import com.example.demo_scaff_snap.dataStore.PreferenceDataStoreModule
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class CommonBinding {

    @Binds
    abstract fun bindPref(preferenceDataStoreModule: PreferenceDataStoreModule): IPreferenceDataStoreAPI

}