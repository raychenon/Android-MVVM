package com.raychenon.androidx.jetpack.albumlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.raychenon.androidx.jetpack.R
import kotlinx.android.synthetic.main.list_activity.*

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [AlbumDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class AlbumListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        setSupportActionBar(toolbar)
        toolbar.title = title

        if (savedInstanceState == null) {
            val fragment = AlbumGridFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentcontainerMain, fragment).commit()
        }
    }
}
