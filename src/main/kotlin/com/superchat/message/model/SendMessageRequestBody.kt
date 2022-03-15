package com.superchat.message.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class SendMessageRequestBody(
    @field:NotBlank(message = "Content must not be blank")
    val content: String,
    @field:Min(message = "Recipient must not be null and must be greater than 1", value = 1)
    val recipientId: Long,
)
