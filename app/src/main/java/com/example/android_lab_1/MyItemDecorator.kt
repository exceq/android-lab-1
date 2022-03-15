package com.example.android_lab_1

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import androidx.core.view.children
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView

//https://temofeev.ru/info/articles/kastomnyy-itemdecoration-dlya-recyclerview/

class MyItemDecorator(private val dividerDrawable: Drawable) :
    RecyclerView.ItemDecoration() {

    private val dividerWidth = dividerDrawable.intrinsicWidth
    private val dividerHeight = dividerDrawable.intrinsicHeight

    override fun getItemOffsets(rect: Rect, v: View, parent: RecyclerView, s: RecyclerView.State) {
        parent.adapter?.let { adapter ->
            val childAdapterPosition = parent.getChildAdapterPosition(v)
                .let { if (it == RecyclerView.NO_POSITION) return else it }
            rect.right = // Add space/"padding" on right side
                if (childAdapterPosition == adapter.itemCount - 1) 0    // No "padding"
                else dividerWidth                                       // Drawable width "padding"
        }
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        parent.adapter?.let { adapter ->
            parent.children // Displayed children on screen
                .forEach { view ->
                    val position = parent.getChildAdapterPosition(view)
                        .let { if (it == RecyclerView.NO_POSITION) return else it }


                    val ad = parent.adapter
                    Log.d("DEBUG", "ad?.getItemId(position) at pos $position = " + ad?.getItemViewType(position))
                    if (position != adapter.itemCount - 1
                       && ad?.getItemViewType(position) == ad?.getItemViewType(position + 1)
                    ) {
                        val left = 120
                        val top = view.bottom
                        val right = 900
                        val bottom = view.bottom + dividerHeight
                        dividerDrawable.bounds = Rect(left, top, right, bottom)
                        Log.d("DEBUG", "RECT "+Rect(left, top, right, bottom))
                        dividerDrawable.draw(canvas)
                    }
                }
        }
    }
}