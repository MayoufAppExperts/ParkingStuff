package com.example.theappexperts.parkingapp.SDI.module;

import android.app.Application;
import android.content.Context;


import com.example.theappexperts.parkingapp.AppDataManager;
import com.example.theappexperts.parkingapp.DataManager;
import com.example.theappexperts.parkingapp.SDI.scope.ApplicationContext;
import com.example.theappexperts.parkingapp.network.ApiHelper;
import com.example.theappexperts.parkingapp.network.AppApiHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TheAppExperts on 03/10/2017.
 */

@Module

public class ApplicationModule {

    Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context context(){
        return application;
    }

    @Provides
    Application getApplication(){
        return application;
    }

    @Provides
    @Singleton
    DataManager provideAppDataManager(AppDataManager appDataManager){
        return appDataManager;
    }
    @Provides
    @Singleton
    ApiHelper provideAppApiHelper(AppApiHelper appApiHelper){
        return appApiHelper;

    }

}
