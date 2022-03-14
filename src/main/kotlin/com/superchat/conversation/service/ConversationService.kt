package com.superchat.conversation.service

import com.superchat.contact.service.ContactService
import com.superchat.contact.util.toResponseBody
import com.superchat.conversation.model.ConversationResponseBody
import com.superchat.message.service.MessageService
import org.springframework.stereotype.Service

@Service
class ConversationService(
    private val contactService: ContactService,
    private val messageService: MessageService
) {
    fun getPreviousConversationsFromContact(id: Long): ConversationResponseBody {
        val contact = contactService.getContactById(id)
        val messages = messageService.getPreviousConversationsWithContact(id)
        return ConversationResponseBody(contact = contact.toResponseBody(), messages = messages)
    }
}