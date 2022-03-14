package com.superchat.error

import com.superchat.error.exceptions.ApiException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class SuperchatErrorHandlingControllerAdvice {

    @ExceptionHandler(value = [ApiException::class])
    fun onApiException(exception: ApiException): ResponseEntity<Any?>? {
        return ResponseEntity(exception.message, exception.getStatusCode())
    }
}