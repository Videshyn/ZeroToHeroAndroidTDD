package ru.easycode.zerotoheroandroidtdd

import java.io.Serializable

interface Count: Serializable {

    fun increment(number: String): String

    class Base(private val step: Int): Count {


        init {
            if (step < 1) {
                throw IllegalStateException("step should be positive, but was $step")
            }
        }

        override fun increment(number: String): String {
            val digits = number.toIntOrNull() ?: throw IllegalStateException("provided data is invalid")
            val result = digits + step
            return result.toString()
        }

    }
}