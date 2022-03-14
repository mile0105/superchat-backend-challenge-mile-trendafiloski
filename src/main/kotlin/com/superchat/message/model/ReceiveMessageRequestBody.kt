package com.superchat.message.model

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ReceiveMessageRequestBody(
    @field:NotBlank(message = "Content must not be blank")
    val content: String,
    @field:NotNull(message = "Sender must not be null")
    val senderId: Long,
    @field:NotBlank(message = "Channel must not be blank")
    val channel: String,
)