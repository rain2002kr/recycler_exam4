package com.example.recycler_exam4

import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer
{
    val btn  = containerView.findViewById(R.id.button) as Button
    val chkBox  = containerView.findViewById(R.id.checkBox) as CheckBox
}
