package com.jay.offerwalltest.model

class ResponseWrapper<T>(val response: T? = null, val error: Throwable? = null)