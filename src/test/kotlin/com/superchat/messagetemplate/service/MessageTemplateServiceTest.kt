package com.superchat.messagetemplate.service

import com.superchat.contact.model.Contact
import com.superchat.contact.service.ContactService
import com.superchat.error.exceptions.NotFoundException
import com.superchat.messagetemplate.model.MessageTemplate
import com.superchat.messagetemplate.model.MessageTemplateCreationRequestBody
import com.superchat.messagetemplate.model.MessageTemplateResponseBody
import com.superchat.messagetemplate.repository.MessageTemplateRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.util.*

internal class MessageTemplateServiceTest {

    private val messageTemplateRepository: MessageTemplateRepository = mock(MessageTemplateRepository::class.java)
    private val contactService: ContactService = mock(ContactService::class.java)
    private lateinit var messageTemplateService: MessageTemplateService

    @BeforeEach
    internal fun setUp() {
        messageTemplateService = MessageTemplateService(messageTemplateRepository, contactService)
    }

    @Test
    internal fun `Should add new message template`() {
        val contact = Contact(1, "email1", "name1")
        val message = MessageTemplate(null, "Hello {{name}}", contact, "name")
        `when`(messageTemplateRepository.save(message)).thenReturn(message.copy(id = 1))
        `when`(contactService.getContactById(1)).thenReturn(contact)
        val requestBody = MessageTemplateCreationRequestBody("Hello {{name}}", listOf("name"))

        val response = messageTemplateService.addMessageTemplate(requestBody)

        assertEquals(MessageTemplateResponseBody(1, "Hello {{name}}", listOf("name")), response)
    }

    @Test
    internal fun `Should get message template by id`() {
        val contact = Contact(1, "email1", "name1")
        `when`(messageTemplateRepository.findById(1L)).thenReturn(
            Optional.of(
                MessageTemplate(
                    1L,
                    "Hello {{name}}",
                    contact,
                    "name"
                )
            )
        )

        val message = messageTemplateService.getMessageTemplateById(1L)

        assertEquals(message, MessageTemplate(1L, "Hello {{name}}", contact, "name"))
    }

    @Test
    internal fun `Should throw exception if contact cannot be found`() {
        `when`(messageTemplateRepository.findById(1L)).thenReturn(Optional.empty())
        org.junit.jupiter.api.assertThrows<NotFoundException> { messageTemplateService.getMessageTemplateById(1L) }
    }
}