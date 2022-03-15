package com.superchat.conversation.service

import com.superchat.contact.model.Contact
import com.superchat.contact.model.ContactResponseBody
import com.superchat.contact.service.ContactService
import com.superchat.conversation.model.ConversationResponseBody
import com.superchat.message.model.MessageResponseBody
import com.superchat.message.service.MessageService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.time.LocalDateTime

internal class ConversationServiceTest {
    private val contactService: ContactService = mock(ContactService::class.java)
    private val messageService: MessageService = mock(MessageService::class.java)
    private lateinit var conversationService: ConversationService

    @BeforeEach
    internal fun setUp() {
        conversationService = ConversationService(contactService, messageService)
    }

    @Test
    internal fun `Should return the previous conversations from the given contact id`() {
        val contactId = 1L
        val messages = listOf(
            MessageResponseBody(
                1,
                "first",
                Contact(1, "ee", "nn"),
                Contact(2, "email", "name"),
                "INTERNAL",
                LocalDateTime.MIN
            )
        )
        `when`(contactService.getContactById(contactId)).thenReturn(Contact(2, "email", "name"))
        `when`(messageService.getPreviousConversationsWithContact(contactId)).thenReturn(messages)

        val conversations = conversationService.getPreviousConversationsFromContact(contactId)


        assertEquals(
            ConversationResponseBody(
                contact = ContactResponseBody(2, "email", "name"),
                messages = messages
            ), conversations
        )
    }
}