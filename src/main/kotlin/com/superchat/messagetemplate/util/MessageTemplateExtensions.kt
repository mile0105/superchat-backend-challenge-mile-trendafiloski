package com.superchat.messagetemplate.util

import com.superchat.contact.service.ContactService
import com.superchat.message.model.Message
import com.superchat.message.model.SendMessageRequestBody
import com.superchat.messagetemplate.model.MessageTemplate
import com.superchat.messagetemplate.model.MessageTemplateCreationRequestBody
import com.superchat.messagetemplate.model.MessageTemplateResponseBody
import java.time.LocalDateTime

fun MessageTemplate.toResponse(): MessageTemplateResponseBody  {
    return MessageTemplateResponseBody(id!!, template, parameters.split(","))
}

fun MessageTemplateCreationRequestBody.toDbModel(contactService: ContactService): MessageTemplate {
    val currentContact = contactService.getContactById(1L) //this should be taken from the principal
    return MessageTemplate(null, template, currentContact, parameters.joinToString(separator = ","))
}
