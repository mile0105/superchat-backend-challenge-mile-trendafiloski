package com.superchat.message.model

import com.superchat.contact.model.Contact
import java.time.LocalDateTime

data class MessageResponseBody(
    val id: Long,
    val content: String,
    val sender: Contact,
    val recipient: Contact,
    val channel: String,
    val time: LocalDateTime
)