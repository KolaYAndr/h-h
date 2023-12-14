package com.example.myapplication.utils

import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar

class DatePickerFragment{
    companion object {
        fun createDialog(context: Context, listener: DatePickerDialog.OnDateSetListener): DatePickerDialog {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            return DatePickerDialog(context, listener, year, month, day)
        }
    }
}