package com.raychenon.androidx.jetpack

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raychenon.androidx.jetpack.models.Album

class AlbumAdapter(private val albumList: List<Album>, private val listener: (Album) -> Unit) : RecyclerView.Adapter<AlbumHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        return LayoutInflater.from(parent.getContext())
            .inflate(R.layout.album_item_list, parent, false)
            .let { AlbumHolder(it) }
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        holder.apply {
            bindData(getItem(position), listener)
        }
    }

    fun getItem(position: Int): Album {
        return albumList.get(position)
    }

    interface OnItemClickListener {
        fun onItemClick(album: Album)
    }
}
