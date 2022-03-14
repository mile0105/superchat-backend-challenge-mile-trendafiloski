package com.superchat.conversation.model

import com.superchat.contact.model.ContactResponseBody
import com.superchat.message.model.MessageResponseBody

data class ConversationResponseBody(
    val contact: ContactResponseBody,
    val messages: Set<MessageResponseBody>
)