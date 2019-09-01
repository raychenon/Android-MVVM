package com.raychenon.androidx.jetpack

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.raychenon.androidx.jetpack.data.RetrofitFactory
import com.raychenon.androidx.jetpack.models.AlbumLiveDataState

class AlbumGridViewModel : ViewModel() {

    val TAG = "AlbumGridViewModel"

    val service = RetrofitFactory.getAlbumServiceInstance()

    fun getAlbumResponse(id: Int): LiveData<AlbumLiveDataState> = liveData {
        Log.d("AlbumGridViewModel", "before call getAlbumsResponse")

        try {
            val response = service.getAlbumsResponse(id)
            if (response.isSuccessful) {
                Log.d(TAG, "isSuccessful")
                val albumLiveState = AlbumLiveDataState(response.isSuccessful, response.body()!!, "")
                emit(albumLiveState)
            } else {
                Log.d(TAG, "Server failed ")
                val albumLiveState = AlbumLiveDataState(!response.isSuccessful, null, response.errorBody()?.string())
                emit(albumLiveState)
            }
        } catch (e: Throwable) {
            Log.d(TAG, "catch ")
            val albumLiveState = AlbumLiveDataState(false, null, e.localizedMessage)
            emit(albumLiveState)
        }
    }
}
