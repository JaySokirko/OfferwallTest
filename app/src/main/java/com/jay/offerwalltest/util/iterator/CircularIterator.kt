package com.jay.offerwalltest.util.iterator

class CircularIterator<T> : Iterator<T> {

    private val list: MutableList<T> = mutableListOf()
    private var currentPosition: Int = 0

    fun setCollection(collection: Collection<T>) {
       list.apply { clear(); list.addAll(collection) }
    }

    override fun hasNext(): Boolean {
        return currentPosition < list.size
    }

    override fun getNext(): T {
        if (hasNext()) {
            return list[currentPosition++]
        } else {
            resetIterator()
            return list[currentPosition++]
        }
    }

    fun resetIterator() {
        currentPosition = 0
    }
}