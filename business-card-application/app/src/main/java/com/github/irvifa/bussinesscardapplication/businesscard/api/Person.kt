package com.github.irvifa.bussinesscardapplication.businesscard.api

data class Person(
    val fullName: String,
    val title: String,
    val contact: Contact
)

data class Contact(
    val phoneNumber: String,
    val email: String,
    val socialMediaHandle: String)
