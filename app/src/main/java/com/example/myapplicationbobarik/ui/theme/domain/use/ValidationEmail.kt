package com.example.myapplicationbobarik.ui.theme.domain.use

import android.util.Patterns

class ValidationEmail {

    fun execute(email: String):ValidationRezults
    {
        if(email.isBlank())
        {
            return ValidationRezults(
                succsesful = false,
                errorMessage = "Введите электронную почту"
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            return ValidationRezults(
                succsesful = false,
                errorMessage = "Электронная почта введена неверно"
            )
        }
        return ValidationRezults(
            succsesful = true
        )
    }

}