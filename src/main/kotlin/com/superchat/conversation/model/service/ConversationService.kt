package com.superchat.conversation.model.service

import com.superchat.contact.service.ContactService
import com.superchat.message.service.MessageService
import org.springframework.stereotype.Service

@Service
class ConversationService(
    contactService: ContactService,
    messageService: MessageService
) {


}