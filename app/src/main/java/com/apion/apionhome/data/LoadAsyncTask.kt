package com.apion.apionhome.data

import android.os.AsyncTask
import java.lang.Exception

class LoadAsyncTask<T, P>(
    private val callback: OnDataCallback<P>,
    private val handler: (T) -> P?
): AsyncTask<T, Unit, P>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg p0: T): P? {
        return try {
            handler(p0[0])
        }catch (e:Exception){
            this.exception = e;
            null
        }
    }

    override fun onPostExecute(result: P?) {
        super.onPostExecute(result)
        result?.let {
            callback.onSuccess(it)
        } ?: callback.onError(exception ?: Exception())
    }
}