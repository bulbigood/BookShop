package com.example.booktask.utils

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.booktask.App
import com.example.booktask.ViewModelFactory

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val app = requireContext().applicationContext as App
    return ViewModelFactory(
        app.profileRepository,
        app.finishedBooksRepository,
        this
    )
}

fun Fragment.toast(message: String, isLong: Boolean = false) {
    val length = if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
    Toast.makeText(context, message, length).apply {
        show()
    }
}