package com.superchat.message.model

data class MessageFromTemplateRequestBody (
    val templateId: Long,
    val recipientId: Long,
    val parameters: Map<String, String>
)
