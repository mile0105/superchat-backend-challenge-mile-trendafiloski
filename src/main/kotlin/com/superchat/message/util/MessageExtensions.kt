package com.superchat.message.util

import com.superchat.contact.service.ContactService
import com.superchat.message.model.*
import java.time.LocalDateTime

fun SendMessageRequestBody.toDbModel(contactService: ContactService): Message {
    val sender = contactService.getContactById(1L) // in a real world app we would use the jwt
    val recipient = contactService.getContactById(recipientId)
    return Message(null, content = content, time = LocalDateTime.now(), sender = sender, recipient = recipient, channel = Channel.INTERNAL)
}

fun Message.toResponseBody(): MessageResponseBody {
    return MessageResponseBody(id = id!!, content = content, sender = sender, recipient = recipient, time = time, channel = channel.name)
}

fun ReceiveMessageRequestBody.toDbModel(contactService: ContactService): Message {
    val recipient = contactService.getContactById(1L) //in a real world app this should be sent to the appropriate recipient
    val sender = contactService.getContactById(senderId)
    return Message(null, content = content, time = LocalDateTime.now(), sender = sender, recipient = recipient, channel = Channel.valueOf(channel))
}

