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

    private lateinit var dialog: LoadingDialog
    private lateinit var searchViewModel: MainViewModel
    private lateinit var adapter: KeywordAdapter

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
        rv_definition.layoutManager = layoutManager
        adapter = KeywordAdapter(this)
        rv_definition.adapter = adapter

        val animation = AnimationUtils
            .loadLayoutAnimation(this, R.anim.layout_animation_from_right)
        rv_definition.layoutAnimation = animation
        dialog = LoadingDialog(this)
        searchKeyword()
    }


    private fun initViewModel() {
        searchViewModel = ViewModelProviders
            .of(this)
            .get(MainViewModel::class.java)
        searchViewModel
            .let {
                lifecycle.addObserver(it)
            }
    }

    private fun searchKeyword() {
        showLoadingDialog()
        searchViewModel
            .getData()?.observe(
                this,
                Observer { definitionList ->
                    adapter.updateInfo(definitionList!!)
                    reRunAnimation()
                    rv_definition.smoothScrollToPosition(0)
                    hideLoadingDialog()
                })
    }

    private fun reRunAnimation() {
        rv_definition.scheduleLayoutAnimation()
    }

    private fun showLoadingDialog() {
        dialog.showDialog()
    }

    private fun hideLoadingDialog() {
        dialog.hideDialog()
    }
}
