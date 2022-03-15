package com.superchat.message.service

import com.superchat.contact.model.Contact
import com.superchat.contact.service.ContactService
import com.superchat.message.model.*
import com.superchat.message.repository.MessageRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.*
import org.springframework.messaging.simp.SimpMessagingTemplate
import java.time.LocalDateTime

internal class MessageServiceTest {

    private val messageRepository: MessageRepository = mock(MessageRepository::class.java)
    private val contactService: ContactService = mock(ContactService::class.java)
    private val simpMessagingTemplate: SimpMessagingTemplate = mock(SimpMessagingTemplate::class.java)
    private lateinit var messageService: MessageService
    private val messageCaptor = ArgumentCaptor.forClass(Message::class.java)

    private val sender = Contact(1, "email", "name")
    private val receiver = Contact(2, "email2", "name2")

    @BeforeEach
    internal fun setUp() {
        `when`(contactService.getContactById(1)).thenReturn(sender)
        `when`(contactService.getContactById(2)).thenReturn(receiver)
        messageService = MessageService(messageRepository, contactService, simpMessagingTemplate)
    }

    @Test
    internal fun `Should send message`() {
        val messageRequestBody = SendMessageRequestBody("content", 2)
        val savedMessage = Message(
            1,
            "content",
            LocalDateTime.MIN,
            Channel.INTERNAL,
            sender,
            receiver
        )
        `when`(messageRepository.save(messageCaptor.capture())).thenReturn(savedMessage)

        val sentMessage = messageService.sendMessage(messageRequestBody)

        verify(simpMessagingTemplate).convertAndSend("/topic/messages/2", savedMessage)
        assertEquals(MessageResponseBody(1, "content", sender, receiver, "INTERNAL", LocalDateTime.MIN), sentMessage)

        val capturedMessage = messageCaptor.value
        assertEquals(savedMessage.copy(id = null), capturedMessage.copy(time = LocalDateTime.MIN))
    }

    @Test
    internal fun `Should receive message`() {

        val messageRequestBody = ReceiveMessageRequestBody("content", 2, Channel.SMS.name)
        val savedMessage = Message(
            1,
            "content",
            LocalDateTime.MIN,
            Channel.SMS,
            receiver,
            sender
        )
        `when`(messageRepository.save(messageCaptor.capture())).thenReturn(savedMessage)

        val sentMessage = messageService.receiveMessage(messageRequestBody)

        verify(simpMessagingTemplate).convertAndSend("/topic/messages/1", savedMessage)
        assertEquals(MessageResponseBody(1, "content", receiver, sender, "SMS", LocalDateTime.MIN), sentMessage)

        val capturedMessage = messageCaptor.value
        assertEquals(savedMessage.copy(id = null), capturedMessage.copy(time = LocalDateTime.MIN))
    }

    @Test
    internal fun shouldReturnPreviousConversationsWithTheGivenContact() {

        `when`(messageRepository.findPreviousMessagesBetweenTwoContacts(1L, 2L)).thenReturn(
            listOf(
                Message(1, "Hi", LocalDateTime.MIN, Channel.SMS, sender, receiver),
                Message(2, "Do I know you?", LocalDateTime.MAX, Channel.SMS, receiver, sender)
            )
        )

        val messages = messageService.getPreviousConversationsWithContact(2L)


        assertEquals(
            listOf(
                MessageResponseBody(1, "Hi", sender, receiver, "SMS", LocalDateTime.MIN),
                MessageResponseBody(2, "Do I know you?", receiver, sender, "SMS", LocalDateTime.MAX),
            ), messages
        )
    }
}