package tweentyscoops.mvp.kotlin.configuration

import tweentyscoops.mvp.kotlin.BuildConfig

class BuildConfiguration(val userToken: String) : Config {
    override fun isDebug(): Boolean = BuildConfig.DEBUG
    override fun version(): String = BuildConfig.VERSION_NAME
    override fun userToken(): String? = userToken
}
