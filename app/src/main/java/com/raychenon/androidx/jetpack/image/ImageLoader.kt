package com.raychenon.androidx.jetpack.image

import android.view.animation.LinearInterpolator
import android.widget.ImageView
import com.raychenon.androidx.jetpack.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation

/**
 * Facade to interface with any Image loader library ( Picasso, Fresco or Glide)
 */
object ImageLoader {

    val ANIMATION_DURATION: Long = 800

    fun loadWithFadeInAnimation(imageView: ImageView, url: String, animationDuration: Long = ANIMATION_DURATION) {

        Picasso.get().load(url)
            .into(imageView, createAnimationCallback(imageView, animationDuration))
    }

    fun loadWithFadeInAnimation(imageView: ImageView, url: String, transformation: Transformation, animationDuration: Long = ANIMATION_DURATION) {

        Picasso.get().load(url)
            .transform(transformation)
            .into(imageView, createAnimationCallback(imageView, animationDuration))
    }

    private fun createAnimationCallback(imageView: ImageView, animationDuration: Long) = object : Callback {

        override fun onSuccess() {

            imageView.alpha = 0.05f
            imageView.animate().apply {
                interpolator = LinearInterpolator()
                duration = animationDuration
                alpha(1f)
                startDelay = 0
                start()
            }
        }

        override fun onError(e: Exception?) {
            imageView.setImageResource(R.drawable.fruit)
        }
    }
}
