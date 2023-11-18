package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface Count {

    fun increment(number: String): UiState
    fun decrement(number: String): UiState
    fun initial(number: String): UiState

    class Base(private val step: Int, private val max: Int, private val min: Int): Count {

        init {
            if (step <= 0) throw IllegalStateException("step should be positive, but was $step")
            if (max < 0) throw IllegalStateException("max should be positive, but was $max")
            if (min > max) throw IllegalStateException("max should be more than min")
            if (step > max) throw IllegalStateException("max should be more than step")

        }

        override fun increment(number: String): UiState {
            val digit = number.toIntOrNull() ?: throw IllegalStateException("provided value is invalid")
            val result = digit + step

            return if (result + step > max) UiState.Max(text = result.toString())
            else UiState.Base(text = result.toString())
        }

        override fun decrement(number: String): UiState {
            val digit = number.toIntOrNull() ?: throw IllegalStateException("provided value is invalid")
            val result = digit - step

            return if (result - step < min) UiState.Min(text = result.toString())
            else UiState.Base(text = result.toString())
        }

        override fun initial(number: String): UiState {
            val digit = number.toIntOrNull() ?: throw IllegalStateException("provided value is invalid")

            return when (digit) {
                max -> UiState.Max(text = digit.toString())
                min -> UiState.Min(text = digit.toString())
                else -> UiState.Base(text = digit.toString())
            }
        }

    }
}

interface UiState: Serializable {

    fun apply(textView: TextView, btnInc: Button, btnDec: Button)


    data class Base(val text: String): UiState {
        override fun apply(textView: TextView, btnInc: Button, btnDec: Button) {
            textView.text = text
            btnDec.isEnabled = true
            btnInc.isEnabled = true
        }

    }

    data class Max(val text: String): UiState {
        override fun apply(textView: TextView, btnInc: Button, btnDec: Button) {
            textView.text = text
            btnInc.isEnabled = false
            btnDec.isEnabled = true
        }

    }

    data class Min(val text: String): UiState {
        override fun apply(textView: TextView, btnInc: Button, btnDec: Button) {
            textView.text = text
            btnDec.isEnabled = false
            btnInc.isEnabled = true
        }
    }
}