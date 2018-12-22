package ha.thanh.tiktest.data.remote

import io.reactivex.Observable
import retrofit2.http.GET

interface RemoteService {

    @GET(RemoteContract.END_POINT)
    fun getData(): Observable<List<String>>

}


