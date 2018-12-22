package ha.thanh.tiktest.data.repository

import android.arch.lifecycle.LiveData

interface Repository {

    fun getData(): LiveData<List<String>>

}
