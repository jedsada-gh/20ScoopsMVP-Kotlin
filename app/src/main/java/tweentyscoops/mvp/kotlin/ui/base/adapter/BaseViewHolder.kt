package tweentyscoops.mvp.kotlin.ui.base.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tweentyscoops.mvp.kotlin.extensions.inflate

open class BaseViewHolder(parent: ViewGroup?, layout: Int) : RecyclerView.ViewHolder(parent?.inflate(layout))