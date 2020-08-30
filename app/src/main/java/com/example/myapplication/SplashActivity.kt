package com.example.myapplication

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability

private val TAG = SplashActivity::class.java.simpleName

class SplashActivity : Activity() {

    private var appUpdateManager: AppUpdateManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appUpdateManager = AppUpdateManagerFactory.create(this)
        val appUpdateInfoTask = appUpdateManager.appUpdateInfo
        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
            when (appUpdateInfo.updateAvailability()) {
                UpdateAvailability.UPDATE_AVAILABLE -> {
                    if (appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)) {
                        val build = AlertDialog.Builder(this)
                        build.setTitle("更新").setMessage("有更新喔")
                                .setPositiveButton("OK") { dialog, _ ->
                                    dialog.dismiss()
                                    appUpdateManager.startUpdateFlowForResult(appUpdateInfo, AppUpdateType.IMMEDIATE, this, 1001)
                                }.setNegativeButton("不要") { dialog, _ ->
                                    dialog.dismiss()
                                }
                    } else if (appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)) {
                        //非強制性更新
                    }
                }
                UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS -> {

                }
                UpdateAvailability.UNKNOWN -> {

                }
                UpdateAvailability.UPDATE_NOT_AVAILABLE -> {

                }
            }
        }

        appUpdateInfoTask.addOnFailureListener { e: Exception? ->
            Log.e("TAG", e.toString())
        }
        appUpdateManager.registerListener { state ->
            Log.i(TAG, "state $state")
            if (state.installStatus() == InstallStatus.DOWNLOADING) {
                val bytesDownloaded = state.bytesDownloaded()
                val totalBytesToDownload = state.totalBytesToDownload()
                // Show update progress bar.
                popupSnackbarForCompleteUpdate()
            }
        }
    }

    fun popupSnackbarForCompleteUpdate() {
        Snackbar.make(
                findViewById(R.id.view_frame),
                "An update has just been downloaded.",
                Snackbar.LENGTH_INDEFINITE
        ).apply {
            setAction("RESTART") { appUpdateManager?.completeUpdate() }
            setActionTextColor(Color.parseColor("#000000"))
            show()
        }
    }
}