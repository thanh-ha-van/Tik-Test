package ha.thanh.tiktest.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import ha.thanh.tiktest.data.remote.RemoteService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl
@Inject constructor(
    private val remoteService: RemoteService
) : Repository {

    val allCompositeDisposable: MutableList<Disposable> = arrayListOf()

    override fun getData(): LiveData<List<String>> {
        val mutableLiveData = MutableLiveData<List<String>>()
        val disposable =
            remoteService.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { it ->
                        mutableLiveData.value = it
                    },
                    { t: Throwable? ->
                        t?.printStackTrace()
                    }
                )
        allCompositeDisposable.add(disposable)
        return mutableLiveData
    }

}
