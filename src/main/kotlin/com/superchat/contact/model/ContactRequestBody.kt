package com.superchat.contact.model

import javax.validation.constraints.NotBlank

data class ContactRequestBody(
    @field:NotBlank(message = "Email must not be blank")
    val email: String,
    @field:NotBlank(message = "Name must not be blank")
    val name: String,
)
