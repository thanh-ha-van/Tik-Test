package ha.thanh.tiktest.di

import dagger.Component
import ha.thanh.tiktest.MainViewModel
import javax.inject.Singleton

@Component(modules = [AppModule::class, RemoteModule::class])
@Singleton
interface AppComponent {

    fun inject(homeViewModel: MainViewModel)
}
