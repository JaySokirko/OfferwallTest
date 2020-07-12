package com.jay.offerwalltest.model.record

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestA {

    @SerializedName("id")
    @Expose
    var id = 0

    @SerializedName("title")
    @Expose
    var title: String? = null
}