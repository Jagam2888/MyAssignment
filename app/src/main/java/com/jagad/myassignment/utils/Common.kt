package com.jagad.myassignment.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by jagad on 9/18/2021
 */
fun Context.toast(msg:String){
    Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
}