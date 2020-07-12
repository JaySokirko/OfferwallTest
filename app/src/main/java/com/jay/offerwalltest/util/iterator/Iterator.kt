package com.jay.offerwalltest.util.iterator

interface Iterator<T> {

    fun hasNext(): Boolean
    fun getNext(): T
}