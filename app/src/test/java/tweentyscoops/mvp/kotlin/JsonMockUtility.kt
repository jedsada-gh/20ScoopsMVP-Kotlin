package tweentyscoops.mvp.kotlin

import com.google.gson.GsonBuilder

class JsonMockUtility {

    fun <T> getJsonToMock(fileName: String, className: Class<T>): T =
            GsonBuilder().create().fromJson<T>(getJsonFromResources(fileName), className)

    private fun getJsonFromResources(fileName: String): String =
            this.javaClass.classLoader.getResourceAsStream(fileName).bufferedReader().use { it.readText() }
}
