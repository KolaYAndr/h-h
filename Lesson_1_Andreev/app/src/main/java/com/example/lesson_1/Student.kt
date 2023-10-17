package com.example.lesson_1

data class Student(
    val id: Long = System.currentTimeMillis(),
    val name: String,
    val surname: String,
    val grade: String,
    val birthdayYear: Int
)