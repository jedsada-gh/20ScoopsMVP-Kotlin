package tweentyscoops.mvp.kotlin.ui.base.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import tweentyscoops.mvp.kotlin.extensions.inflate

abstract class BaseViewHolder(parent: ViewGroup, layout: Int) :
        RecyclerView.ViewHolder(parent.inflate(layout)) {

    init {
        @Suppress("LeakingThis")
        bindView(itemView)
    }

    abstract fun bindView(view: View)

    protected fun getContext() = itemView.context
}