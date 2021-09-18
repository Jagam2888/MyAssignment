package com.jagad.myassignment.utils

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * Created by jagad on 9/18/2021
 */
@BindingAdapter("underline")
fun underline(textView: TextView,isUnderline:Boolean){
    if (isUnderline)
        textView.paintFlags = textView.paintFlags or Paint.UNDERLINE_TEXT_FLAG
}