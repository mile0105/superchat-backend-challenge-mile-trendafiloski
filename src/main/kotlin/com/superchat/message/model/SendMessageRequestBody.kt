package com.superchat.message.model

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class SendMessageRequestBody(
    @field:NotBlank(message = "Content must not be blank")
    val content: String,
    @field:Size(message = "Recipient must not be null and must be greater than 1", min = 1)
    val recipientId: Long,
)
