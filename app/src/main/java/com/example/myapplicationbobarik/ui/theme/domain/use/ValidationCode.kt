package com.example.myapplicationbobarik.ui.theme.domain.use

import android.util.Patterns

class ValidationCode {
    fun execute(code: String):ValidationRezults
    {

        if(!Patterns.EMAIL_ADDRESS.matcher(code).matches())
        {
            return ValidationRezults(
                succsesful = false,
                errorMessage = "Неверный код"
            )
        }
        return ValidationRezults(
            succsesful = true
        )
    }
}