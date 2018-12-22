package ha.thanh.tiktest

import android.arch.lifecycle.*
import ha.thanh.tiktest.data.repository.RepositoryImpl
import ha.thanh.tiktest.di.MyApp
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var mRepository: RepositoryImpl

    private val mCompositeDisposable = CompositeDisposable()

    private var mLiveDefinitionData: LiveData<List<String>>? = null

    init {
        MyApp.appComponent.inject(this)
    }

    fun getData(): LiveData<List<String>>? {
        mLiveDefinitionData = null
        mLiveDefinitionData = MutableLiveData<List<String>>()
        mLiveDefinitionData = mRepository.getData()
        return mLiveDefinitionData
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun unSubscribeViewModel() {
        for (disposable in mRepository.allCompositeDisposable) {
            mCompositeDisposable.addAll(disposable)
        }
        mCompositeDisposable.clear()
    }

    override fun onCleared() {
        unSubscribeViewModel()
        super.onCleared()
    }
}
