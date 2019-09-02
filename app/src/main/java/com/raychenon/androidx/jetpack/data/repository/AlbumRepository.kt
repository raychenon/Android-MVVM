package com.raychenon.androidx.jetpack.data.repository

import com.raychenon.androidx.jetpack.data.AlbumService

class AlbumRepository(val service: AlbumService) {

//    val TAG = "AlbumRepository"
//
//    private var dataRetained: AlbumLiveDataState? = null
//
//    fun fetchNetworkAlbumResponse(id: Int): AlbumLiveDataState {
//        if(dataRetained == null){
//            return fetchNetworkAlbumResponse(id)
//        }else{
//            return dataRetained
//        }
//    }
//
//    fun fetchNetworkAlbumResponse(id: Int): AlbumLiveDataState {
//        Log.d("HomeViewModel", "before call getAlbumsResponse")
//        GlobalScope.async {
//        try {
//            val response = service.getAlbumsResponse(id)
//            if (response.isSuccessful) {
//                Log.d(TAG, "isSuccessful")
//                val albumLiveState = AlbumLiveDataState(response.isSuccessful, response.body()!!, "")
//                dataRetained = albumLiveState
//                return albumLiveState
//
//            } else {
//                Log.d(TAG, "Server failed ")
//                return AlbumLiveDataState(!response.isSuccessful, null, response.errorBody()?.string())
//
//            }
//
//        } catch (e: Throwable) {
//            Log.d(TAG, "catch ")
//            return AlbumLiveDataState(false, null, e.localizedMessage)
//        }
//
//    }
}
