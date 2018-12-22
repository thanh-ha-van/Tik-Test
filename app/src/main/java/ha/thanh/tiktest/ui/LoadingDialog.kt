package ha.thanh.tiktest.ui

import android.app.Activity
import android.app.Dialog
import android.view.Window
import ha.thanh.tiktest.R


class LoadingDialog(private var activity: Activity) {

    private lateinit var mDialog: Dialog

    fun showDialog() {
        mDialog = Dialog(activity)
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mDialog.setCancelable(false)
        mDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        mDialog.setContentView(R.layout.dialog_loading)
        mDialog.show()
    }

    fun hideDialog() {
        mDialog.dismiss()
    }
}