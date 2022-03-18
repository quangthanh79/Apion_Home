package com.apion.apionhome.data

interface OnDataCallback<T> {

    fun onSuccess(data: T?)

    fun onError(throwable: Throwable)
}
