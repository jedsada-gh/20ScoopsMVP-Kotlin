package tweentyscoops.mvp.kotlin.configuration

interface Config {
    fun isDebug(): Boolean
    fun version(): String
    fun userToken(): String?
    fun endPoint(): String
    fun deviceType(): String
}