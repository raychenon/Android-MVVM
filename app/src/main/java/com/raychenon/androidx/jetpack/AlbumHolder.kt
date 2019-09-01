package com.raychenon.androidx.jetpack

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raychenon.androidx.jetpack.image.ImageLoader
import com.raychenon.androidx.jetpack.models.Album
import com.squareup.picasso.Transformation
import jp.wasabeef.picasso.transformations.MaskTransformation

class AlbumHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

    private val titleView get() = itemView.findViewById<TextView>(R.id.album_title)
    private val artistTextView get() = itemView.findViewById<TextView>(R.id.artist_name)
    private val albumCover get() = itemView.findViewById<ImageView>(R.id.album_thumbnail)

    private val transformation: Transformation = MaskTransformation(v.getContext(), R.drawable.rounded_transformation)

    fun bindData(item: Album, listener: (Album) -> Unit) {
        albumCover!!.setOnClickListener(View.OnClickListener { listener(item) })

        titleView?.setText(item.title)
        artistTextView?.setText(item.artist.name)

        ImageLoader.loadWithFadeInAnimation(albumCover!!, item.cover_medium, transformation)
    }

    override fun onClick(p0: View?) {
    }
}
