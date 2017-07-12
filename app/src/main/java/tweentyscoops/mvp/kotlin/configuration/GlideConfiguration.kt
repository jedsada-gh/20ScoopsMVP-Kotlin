package tweentyscoops.mvp.kotlin.configuration

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule

class GlideConfiguration : AppGlideModule() {
    override fun applyOptions(context: Context?, builder: GlideBuilder?) {
        builder?.setMemoryCache(LruResourceCache(30 * 1024 * 1024))
    }

    override fun registerComponents(context: Context?, registry: Registry?) {
        // TODO : somethings
    }
}