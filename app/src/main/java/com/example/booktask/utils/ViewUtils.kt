package com.example.booktask.utils

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.booktask.App
import com.example.booktask.R
import com.example.booktask.ViewModelFactory
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

val Fragment.DEFAULT_DATE_FORMAT: SimpleDateFormat
    get() = SimpleDateFormat(getString(R.string.date_format), Locale.getDefault())

fun Fragment.formatRawDate(rawDate: String?, dateFormat: DateFormat): String {
    if (rawDate == null) return ""

    val date = dateFormat.parse(rawDate)
    return if (date != null) DEFAULT_DATE_FORMAT.format(date) else ""
}

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