package tweentyscoops.mvp.kotlin.api.model

import com.google.gson.annotations.SerializedName
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseItem
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseItemType

data class UserRepos(@SerializedName("name") var name: String? = "",
                     @SerializedName("language") var language: String? = "",
                     @SerializedName("git_url") var gitUrl: String? = "",
                     @SerializedName("fork") var fork: Boolean? = false) : BaseItem(BaseItemType.TYPE_NORMAL)