package com.superchat.messagetemplate.service

import com.superchat.contact.service.ContactService
import com.superchat.error.exceptions.NotFoundException
import com.superchat.messagetemplate.model.MessageTemplate
import com.superchat.messagetemplate.model.MessageTemplateCreationRequestBody
import com.superchat.messagetemplate.model.MessageTemplateResponseBody
import com.superchat.messagetemplate.repository.MessageTemplateRepository
import com.superchat.messagetemplate.util.toDbModel
import com.superchat.messagetemplate.util.toResponse
import org.springframework.stereotype.Service

@Service
class MessageTemplateService(
    private val messageTemplateRepository: MessageTemplateRepository,
    private val contactService: ContactService
) {
    fun addMessageTemplate(template: MessageTemplateCreationRequestBody): MessageTemplateResponseBody {
        val savedTemplate = messageTemplateRepository.save(template.toDbModel(contactService))
        return savedTemplate.toResponse()
    }

    fun getMessageTemplateById(id: Long): MessageTemplate {
        return messageTemplateRepository.findById(id).orElseThrow{ NotFoundException("Message template not found") }
    }
}