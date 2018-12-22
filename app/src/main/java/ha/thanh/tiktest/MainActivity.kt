package ha.thanh.tiktest

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.animation.AnimationUtils
import ha.thanh.tiktest.ui.KeywordAdapter
import ha.thanh.tiktest.ui.LoadingDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mDialog: LoadingDialog
    private lateinit var mMainViewModel: MainViewModel
    private lateinit var mAdapter: KeywordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initView()
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL, false
        )
        rv_keyword.layoutManager = layoutManager
        mAdapter = KeywordAdapter(this)
        rv_keyword.adapter = mAdapter

        val animation = AnimationUtils
            .loadLayoutAnimation(this, R.anim.layout_animation_from_right)
        rv_keyword.layoutAnimation = animation
        mDialog = LoadingDialog(this)
        searchKeyword()
    }


    private fun initViewModel() {
        mMainViewModel = ViewModelProviders
            .of(this)
            .get(MainViewModel::class.java)
        mMainViewModel
            .let {
                lifecycle.addObserver(it)
            }
    }

    private fun searchKeyword() {
        showLoadingDialog()
        mMainViewModel
            .getData()?.observe(
                this,
                Observer { definitionList ->
                    mAdapter.updateInfo(definitionList!!)
                    reRunAnimation()
                    rv_keyword.smoothScrollToPosition(0)
                    hideLoadingDialog()
                })
    }

    private fun reRunAnimation() {
        rv_keyword.scheduleLayoutAnimation()
    }

    private fun showLoadingDialog() {
        mDialog.showDialog()
    }

    private fun hideLoadingDialog() {
        mDialog.hideDialog()
    }
}
