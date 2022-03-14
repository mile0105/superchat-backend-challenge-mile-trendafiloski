package com.superchat.error.exceptions

import org.springframework.http.HttpStatus

class NotFoundException(override val message: String): ApiException(message) {

    override fun getStatusCode(): HttpStatus {
        return HttpStatus.NOT_FOUND
    }
}