package com.superchat.message.service

import com.superchat.contact.service.ContactService
import com.superchat.message.model.SendMessageRequestBody
import com.superchat.message.model.MessageResponseBody
import com.superchat.message.model.ReceiveMessageRequestBody
import com.superchat.message.repository.MessageRepository
import com.superchat.message.util.toDbModel
import com.superchat.message.util.toResponseBody
import org.springframework.stereotype.Service

@Service
class MessageService(
    private val messageRepository: MessageRepository,
    private val contactService: ContactService
) {
    fun sendMessage(message: SendMessageRequestBody): MessageResponseBody {
        val savedMessage = messageRepository.save(message.toDbModel(contactService))
        return savedMessage.toResponseBody()
    }

    fun receiveMessage(message: ReceiveMessageRequestBody): MessageResponseBody? {
        val savedMessage = messageRepository.save(message.toDbModel(contactService))
        return savedMessage.toResponseBody()
    }

}
