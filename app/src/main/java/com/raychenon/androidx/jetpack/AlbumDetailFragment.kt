package com.raychenon.androidx.jetpack

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.raychenon.androidx.jetpack.image.ImageLoader
import com.raychenon.androidx.jetpack.models.Album
import kotlinx.android.synthetic.main.item_detail.view.*
import kotlinx.android.synthetic.main.item_detail.view.fab

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [AlbumListActivity]
 * in two-pane mode (on tablets) or a [AlbumDetailActivity]
 * on handsets.
 */
class AlbumDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var item: Album? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = it.getParcelable(ARG_ITEM_ID) as Album?
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        // Show the dummy content as text in a TextView.
        item?.let {
            rootView.item_detail.text = String.format(getString(R.string.by_author), it.artist.name)

            rootView.toolbar_layout?.title = it.title

            ImageLoader.loadWithFadeInAnimation(rootView.detail_imageview_placeholder, it.cover_medium)

            ImageLoader.loadWithFadeInAnimation(rootView.detail_artist_imageview_placeholder, it.artist?.picture_big)

            rootView.fab.setOnClickListener { view ->
                Snackbar.make(
                    view,
                    String.format(getString(R.string.detail_fab_msg), it.artist.name),
                    Snackbar.LENGTH_LONG
                )
                    .setAction("Action", null).show()
            }
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back

                activity?.navigateUpTo(Intent(context, AlbumListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
