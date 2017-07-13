package tweentyscoops.mvp.kotlin.ui.base.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tweentyscoops.mvp.kotlin.extensions.inflate

abstract class BaseViewHolder(parent: ViewGroup, val layout: Int) :
        RecyclerView.ViewHolder(parent.inflate(layout)) {
}