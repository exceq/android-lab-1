package com.example.android_lab_1.ui.main

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView

class RoundItemDecorator(private val background: Drawable, private val itemViewType: Int) :
    RecyclerView.ItemDecoration() {
    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {

        var lastView: View? = null
        parent.adapter?.let { adapter ->
            parent.children // Displayed children on screen
                .forEach { view ->
                    val position = parent.getChildAdapterPosition(view)
                        .let { if (it == RecyclerView.NO_POSITION) return else it }

                    if (lastView == null)
                        lastView = view

                    if (adapter.getItemViewType(parent.getChildAdapterPosition(lastView!!))
                            != adapter.getItemViewType(position)) {
                        lastView = view
                    }

                    if (lastView != null && lastView !== view
                        && adapter.getItemViewType(position) == itemViewType
                            ) {
                        val left = view.left
                        val top = lastView?.top
                        val right = view.right
                        val bottom = view.bottom
                        background.bounds = Rect(left, top!!, right, bottom)
                        background.draw(canvas)
                    }
                }
        }
    }
}