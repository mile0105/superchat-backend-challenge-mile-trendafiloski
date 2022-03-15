package com.superchat.messagetemplate.model

data class MessageTemplateResponseBody(
    val id: Long,
    val template: String,
    val parameters: List<String>
)