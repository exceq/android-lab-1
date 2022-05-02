package com.example.android_lab_1.ui

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView

//https://temofeev.ru/info/articles/kastomnyy-itemdecoration-dlya-recyclerview/

class DividerItemDecorator(private val dividerDrawable: Drawable) :
    RecyclerView.ItemDecoration() {

    private val dividerWidth = dividerDrawable.intrinsicWidth
    private val dividerHeight = dividerDrawable.intrinsicHeight

    override fun getItemOffsets(rect: Rect, v: View, parent: RecyclerView, s: RecyclerView.State) {
        parent.adapter?.let { adapter ->
            val childAdapterPosition = parent.getChildAdapterPosition(v)
                .let { if (it == RecyclerView.NO_POSITION) return else it }
            rect.bottom = // Add space/"padding" on right side
                if (childAdapterPosition == adapter.itemCount - 1) 0    // No "padding"
                else dividerHeight                                     // Drawable height "padding"
        }
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        parent.adapter?.let { adapter ->
            parent.children // Displayed children on screen
                .forEach { view ->
                    val position = parent.getChildAdapterPosition(view)
                        .let { if (it == RecyclerView.NO_POSITION) return else it }

                    if (position != adapter.itemCount - 1
                        && adapter.getItemViewType(position) == adapter.getItemViewType(position + 1)
                    ) {
                        val left = view.left + 50
                        val top = view.bottom
                        val right = left + view.width - 100
                        val bottom = top + dividerHeight
                        dividerDrawable.bounds = Rect(left, top, right, bottom)
                        dividerDrawable.draw(canvas)
                    }
                }
        }
    }
}
