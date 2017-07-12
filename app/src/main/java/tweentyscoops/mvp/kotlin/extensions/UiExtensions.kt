package tweentyscoops.mvp.kotlin.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

infix fun Int.dpToPx(context: Context): Int = this * context.resources.displayMetrics.density.toInt()

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun Context.toast(resourceId: Int) = toast(getString(resourceId))

fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

inline fun <reified T : Activity> Activity.navigate(bundle: Bundle? = null) {
    val intent = Intent(this, T::class.java)
    intent.putExtra("value", bundle)
    startActivity(intent)
}

infix fun ImageView.loadImage(url: String?) {
    val requestOptions = RequestOptions()
    requestOptions.format(DecodeFormat.PREFER_ARGB_8888)
    requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL)
    requestOptions.error(android.R.color.darker_gray)
    requestOptions.placeholder(android.R.color.darker_gray)
    Glide.with(this).setDefaultRequestOptions(requestOptions).load(url).into(this)
}

infix fun TextView.title(title: String?) {
    this.text = title
}