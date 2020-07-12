package com.jay.offerwalltest.model.record

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestB {

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("contents")
    @Expose
    var contents: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null
}