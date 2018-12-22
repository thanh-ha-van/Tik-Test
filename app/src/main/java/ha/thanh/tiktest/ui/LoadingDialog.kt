package ha.thanh.tiktest.ui

import android.app.Activity
import android.app.Dialog
import android.view.Window
import ha.thanh.tiktest.R


class LoadingDialog(private var activity: Activity) {

    private lateinit var dialog: Dialog

    fun showDialog() {
        dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setContentView(R.layout.dialog_loading)
        dialog.show()
    }

    fun hideDialog() {
        dialog.dismiss()
    }
}