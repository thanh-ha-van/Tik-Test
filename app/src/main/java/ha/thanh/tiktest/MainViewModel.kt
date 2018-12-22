package ha.thanh.tiktest

import android.arch.lifecycle.*
import ha.thanh.tiktest.data.repository.RepositoryImpl
import ha.thanh.tiktest.di.MyApp
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var definitionRepository: RepositoryImpl

    private val compositeDisposable = CompositeDisposable()

    private var liveDefinitionData: LiveData<List<String>>? = null

    init {
        MyApp.appComponent.inject(this)
    }

    fun getData(): LiveData<List<String>>? {
        liveDefinitionData = null
        liveDefinitionData = MutableLiveData<List<String>>()
        liveDefinitionData = definitionRepository.getData()
        return liveDefinitionData
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun unSubscribeViewModel() {
        for (disposable in definitionRepository.allCompositeDisposable) {
            compositeDisposable.addAll(disposable)
        }
        compositeDisposable.clear()
    }

    override fun onCleared() {
        unSubscribeViewModel()
        super.onCleared()
    }
}
