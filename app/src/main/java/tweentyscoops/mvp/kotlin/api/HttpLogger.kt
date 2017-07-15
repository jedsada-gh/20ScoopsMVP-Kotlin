package tweentyscoops.mvp.kotlin.api

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import com.orhanobut.logger.Logger
import okhttp3.logging.HttpLoggingInterceptor

class HttpLogger(val gson: Gson) : HttpLoggingInterceptor.Logger {
    override fun log(message: String?) {
        val logName = "OkHttp"
        if (message?.startsWith("{") as Boolean) {
            try {
                val prettyPrintJson = gson.toJson(JsonParser().parse(message))
                Logger.t(logName).json(prettyPrintJson)
            } catch (m: JsonSyntaxException) {
                Log.e(logName, "html header parse failed")
                m.printStackTrace()
                Log.e(logName, message)
            }
        } else {
            Log.d(logName, message)
        }
    }
}