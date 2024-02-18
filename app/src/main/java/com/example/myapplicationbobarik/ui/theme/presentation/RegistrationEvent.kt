package com.example.myapplicationbobarik.ui.theme.presentation

sealed class RegistrationEvent {
    data class EmailChanged(val email:String):RegistrationEvent()
    object submit: RegistrationEvent()
}