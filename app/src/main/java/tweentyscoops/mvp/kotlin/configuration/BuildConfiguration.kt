package tweentyscoops.mvp.kotlin.configuration

import tweentyscoops.mvp.kotlin.BuildConfig

class BuildConfiguration(private val userToken: String?) : Config {
    override fun isDebug(): Boolean = BuildConfig.DEBUG
    override fun version(): String = BuildConfig.VERSION_NAME
    override fun userToken(): String? = userToken
    override fun endPoint(): String = BuildConfig.SERVER
    override fun deviceType(): String = BuildConfig.DEVICE_TYEP
}