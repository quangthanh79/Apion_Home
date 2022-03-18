package com.apion.apionhome.base.exception

data class ApiError(
   val success:Boolean,
   val data: List<Object>,
   val message: String,
)
