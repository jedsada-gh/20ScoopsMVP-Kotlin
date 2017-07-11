package tweentyscoops.mvp.kotlin.configuration

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

class GlideConfiguration : AppGlideModule() {
    override fun applyOptions(context: Context?, builder: GlideBuilder?) {
        val rqo =  RequestOptions()
        rqo.format(DecodeFormat.PREFER_ARGB_8888)
        rqo.diskCacheStrategy(DiskCacheStrategy.ALL)
        rqo.error(android.R.color.darker_gray)
        rqo.placeholder(android.R.color.darker_gray)
    }

    override fun registerComponents(context: Context?, registry: Registry?) {
        // TODO : somethings
    }
}