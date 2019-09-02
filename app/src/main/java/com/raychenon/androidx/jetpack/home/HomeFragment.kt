package com.raychenon.androidx.jetpack.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.raychenon.androidx.jetpack.R
import com.raychenon.androidx.jetpack.detail.AlbumDetailActivity
import com.raychenon.androidx.jetpack.detail.AlbumDetailFragment
import com.raychenon.androidx.jetpack.home.adapter.AlbumAdapter
import com.raychenon.androidx.jetpack.models.Album
import com.raychenon.androidx.jetpack.models.AlbumLiveDataState
import kotlinx.android.synthetic.main.home_recyclerview.*
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    lateinit var albumListViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.home_fragment, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            // https://developer.android.com/topic/libraries/architecture/coroutines
        }

        albumListViewModel = ViewModelProviders.of(this)
            .get(HomeViewModel::class.java)

        albumListViewModel.getAlbumResponse(2529).observe(this, Observer { it ->
            handleResponse(it)
        })
    }

    private fun handleResponse(response: AlbumLiveDataState) {

        if (response.isSuccess) {
            recyclerview.apply {
                layoutManager = GridLayoutManager(context, 3)
                adapter = AlbumAdapter(
                    response.response!!.data,
                    { album: Album -> onItemClicked(album) })
            }
        } else {
            val snackbar = Snackbar.make(
                recyclerview, String.format(getString(R.string.error_msg), response.errorMsg),
                Snackbar.LENGTH_INDEFINITE
            )
            snackbar.show()
        }
    }

    private fun onItemClicked(album: Album) {
        val intent = Intent(context, AlbumDetailActivity::class.java).apply {
            putExtra(AlbumDetailFragment.ARG_ITEM_ID, album)
        }
        startActivity(intent)
    }
}
