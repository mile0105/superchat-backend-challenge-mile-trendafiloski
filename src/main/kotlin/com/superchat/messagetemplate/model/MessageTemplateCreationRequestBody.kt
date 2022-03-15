package com.superchat.messagetemplate.model

import javax.validation.constraints.NotBlank

data class MessageTemplateCreationRequestBody(
    @field:NotBlank(message = "Template must not be empty")
    val template: String,
    val parameters: List<String>
)