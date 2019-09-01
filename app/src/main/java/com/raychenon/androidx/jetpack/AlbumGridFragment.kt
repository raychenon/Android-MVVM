package com.raychenon.androidx.jetpack

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
import com.raychenon.androidx.jetpack.models.Album
import com.raychenon.androidx.jetpack.models.AlbumLiveDataState
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.coroutines.launch

class AlbumGridFragment : Fragment() {

    lateinit var albumListViewModel: AlbumGridViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.activity_item_list, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            // https://developer.android.com/topic/libraries/architecture/coroutines
        }

        albumListViewModel = ViewModelProviders.of(this)
            .get(AlbumGridViewModel::class.java)

        albumListViewModel.getAlbumResponse(2529).observe(this, Observer { it ->
            handleResponse(it)
        })
    }

    private fun handleResponse(response: AlbumLiveDataState) {

        if (response.isSuccess) {
            recycler_view.apply {
                layoutManager = GridLayoutManager(context, 3)
                adapter = AlbumAdapter(response.response!!.data, { album: Album -> onItemClicked(album) })
            }
        } else {
            val snackbar = Snackbar.make(
                recycler_view, String.format(getString(R.string.error_msg), response.errorMsg),
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
