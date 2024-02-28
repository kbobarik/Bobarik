package com.example.myapplicationbobarik.ui.theme.domain.use

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.myapplicationbobarik.ui.theme.presentation.RegestationState
import com.example.myapplicationbobarik.ui.theme.presentation.RegistrationEvent

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