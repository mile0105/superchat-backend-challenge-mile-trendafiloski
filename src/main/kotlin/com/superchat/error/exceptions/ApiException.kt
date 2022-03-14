package com.superchat.error.exceptions

import org.springframework.http.HttpStatus

abstract class ApiException(override val message: String) : RuntimeException(message) {
    abstract fun getStatusCode() : HttpStatus
}