package com.zain.gditask

import android.app.Application
import android.net.Uri
import com.microblink.MicroblinkSDK
import com.microblink.intent.IntentDataTransferMode
import java.io.File
import java.io.FileInputStream


class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        MicroblinkSDK.setLicenseFile("BlinkID.mblic", this);
        MicroblinkSDK.setIntentDataTransferMode(IntentDataTransferMode.PERSISTED_OPTIMISED)
    }
}