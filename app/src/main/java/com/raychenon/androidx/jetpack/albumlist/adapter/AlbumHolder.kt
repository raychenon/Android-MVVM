package com.raychenon.androidx.jetpack.albumlist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.raychenon.androidx.jetpack.R
import com.raychenon.androidx.jetpack.image.ImageLoader
import com.raychenon.androidx.jetpack.models.Album
import com.squareup.picasso.Transformation
import jp.wasabeef.picasso.transformations.MaskTransformation
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.album_item_list.*

class AlbumHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer,
    View.OnClickListener {

    private val transformation: Transformation =
        MaskTransformation(itemView.getContext(),
            R.drawable.rounded_transformation
        )

    override val containerView: View?
        get() = itemView

    fun bindData(item: Album, listener: (Album) -> Unit) {
        imageAlbumThumbnail.setOnClickListener(View.OnClickListener { listener(item) })

        textviewAlbumTitle.text = item.title
        textviewArtistName.text = item.artist.name

        ImageLoader.loadWithFadeInAnimation(imageAlbumThumbnail, item.cover_medium, transformation)
    }

    override fun onClick(p0: View?) {
    }
}
