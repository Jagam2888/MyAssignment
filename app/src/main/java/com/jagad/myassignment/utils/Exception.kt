package com.jagad.myassignment.utils

import java.io.IOException

/**
 * Created by jagad on 9/18/2021
 */
class APIException(message : String) : IOException(message)
class NoInternetException(message: String) : IOException(message)