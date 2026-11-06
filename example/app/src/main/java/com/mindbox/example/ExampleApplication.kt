package com.mindbox.example

import android.app.Application
import cloud.mindbox.mindbox_firebase.MindboxFirebase
import cloud.mindbox.mobile_sdk.Mindbox
import cloud.mindbox.mobile_sdk.MindboxConfiguration
import cloud.mindbox.mobile_sdk.logger.Level


class ExampleApp : Application() {

    companion object {
        private var privateApplication: Application? = null
        val application: Application
            get() = privateApplication!!
    }

    override fun onCreate() {
        super.onCreate()
        privateApplication = this

        //https://developers.maestra.io/docs/android-sdk-initialization
        // Values are injected from example.properties via BuildConfig.
        // To set them manually, replace BuildConfig.MINDBOX_DOMAIN / MINDBOX_ENDPOINT_ID with string literals.
        val domain = BuildConfig.MINDBOX_DOMAIN.ifEmpty { "" } //paste your domain address
        val endpointId = BuildConfig.MINDBOX_ENDPOINT_ID.ifEmpty { "" } //paste your endpointId

        val configuration = MindboxConfiguration.Builder(
            context = applicationContext,
            domain = domain,
            endpointId = endpointId
        )
            .shouldCreateCustomer(true)
            .subscribeCustomerIfCreated(true)
            .build()

        //https://developers.maestra.io/docs/android-sdk-methods#setloglevel
        if (BuildConfig.DEBUG) {
            Mindbox.setLogLevel(level = Level.DEBUG)
        }

        //https://developers.maestra.io/docs/android-sdk-methods#initpushservices
        Mindbox.initPushServices(
            context = applicationContext,
            pushServices = listOf(MindboxFirebase)
        )
        //https://developers.maestra.io/docs/android-sdk-methods#init
        Mindbox.init(
            application = this,
            configuration = configuration,
            pushServices = listOf(MindboxFirebase)
        )

        //https://developers.maestra.io/docs/in-app#android
        chooseInappCallback(selectedInappCallback = RegisterInappCallback.DEFAULT)
        //https://developers.maestra.io/docs/android-sdk-methods#setmessagehandling-since-261
        chooseNotificationImageHandler(selectedImageHandler = NotificationImageHandler.DEFAULT)
    }
}
