package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface Count {

    class Base(private val step: Int, private val max: Int): Count {

        init {
            if (max <= 0) throw IllegalStateException("max should be positive, but was $max")
            if (step <= 0) throw IllegalStateException("step should be positive, but was $step")
            if (max < step) throw IllegalStateException("max should be more than step")
        }

        override fun increment(number: String): UiState {
            val digit = number.toIntOrNull() ?: throw IllegalStateException("provided number is invalid")
            val result = digit + step

            val uiState = when {
                result >= max -> UiState.Max(text = max.toString())
                max - result < step -> UiState.Max(text = result.toString())
                else -> UiState.Base(text = result.toString())
            }

            return uiState
        }

    }


    fun increment(number: String): UiState

}

interface UiState: Serializable {

    fun apply(textView: TextView, button: Button)
    data class Base(val text: String): UiState {
        override fun apply(textView: TextView, button: Button) {
            textView.text = text
            button.isEnabled = true
        }
    }

    data class Max(val text: String): UiState {
        override fun apply(textView: TextView, button: Button) {
            textView.text = text
            button.isEnabled = false
        }
    }
}