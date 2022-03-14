package com.superchat.security

import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.function.Consumer

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
class ValidationHandler {

    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, String?>>? {
        val errors: MutableMap<String, String?> = HashMap()
        ex.allErrors.forEach(Consumer { error: ObjectError ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.getDefaultMessage()
            errors[fieldName] = errorMessage
        })
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors)
    }
}