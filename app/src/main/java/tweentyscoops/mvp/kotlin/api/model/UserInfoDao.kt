package tweentyscoops.mvp.kotlin.api.model

import com.google.gson.annotations.SerializedName

data class UserInfoDao(@SerializedName("login") var username: String? = "",
                       @SerializedName("id") var id: Long? = 0,
                       @SerializedName("avatar_url") var avatarUrl: String? = "",
                       @SerializedName("name") var name: String? = "")