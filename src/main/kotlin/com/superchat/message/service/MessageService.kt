package com.superchat.message.service

import com.superchat.contact.service.ContactService
import com.superchat.message.model.MessageResponseBody
import com.superchat.message.model.ReceiveMessageRequestBody
import com.superchat.message.model.SendMessageRequestBody
import com.superchat.message.repository.MessageRepository
import com.superchat.message.util.toDbModel
import com.superchat.message.util.toResponseBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class MessageService(
    private val messageRepository: MessageRepository,
    private val contactService: ContactService,
    @Autowired
    private val simpMessagingTemplate: SimpMessagingTemplate,
) {

    fun sendMessage(message: SendMessageRequestBody): MessageResponseBody {
        val savedMessage = messageRepository.save(message.toDbModel(contactService))
        simpMessagingTemplate.convertAndSend("/topic/messages/" + message.recipientId, savedMessage)
        return savedMessage.toResponseBody()
    }

    fun receiveMessage(message: ReceiveMessageRequestBody): MessageResponseBody {
        val savedMessage = messageRepository.save(message.toDbModel(contactService))
        simpMessagingTemplate.convertAndSend("/topic/messages/1", savedMessage)
        return savedMessage.toResponseBody()
    }

    fun getPreviousConversationsWithContact(contactId: Long): List<MessageResponseBody> {
        val messages = messageRepository.findPreviousMessagesBetweenTwoContacts(1L, contactId)
        return messages.stream().map { it.toResponseBody() }.toList()
    }

}
