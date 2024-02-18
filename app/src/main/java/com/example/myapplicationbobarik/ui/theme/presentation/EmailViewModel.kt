package com.example.myapplicationbobarik.ui.theme.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.example.myapplicationbobarik.ui.theme.domain.use.ValidationEmail
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class EmailViewModel(
    private val validateEmail: ValidationEmail = ValidationEmail()
):ViewModel() {
    var state by mutableStateOf(RegestationState())

    private val validationEventChannel = Channel<ValidationEvent> ()
    val validationEvent = validationEventChannel.receiveAsFlow()
    fun onEvent(event: RegistrationEvent)
    {
        when(event)
        {
            is RegistrationEvent.EmailChanged ->
            {
                state = state.copy(email = event.email)
            }
            is RegistrationEvent.submit ->
            {
                submitData()
            }

        }

    }

    private fun submitData()
    {
        val emailRezult = validateEmail.execute(state.email)
        val hasError = listOf(
            emailRezult
        ).any{it.errorMessage != null}
        if(hasError)
        {
            state = state.copy(
                emailError = emailRezult.errorMessage
            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Succses)
        }
    }

    sealed class ValidationEvent
    {
        object Succses: ValidationEvent()
    }

}