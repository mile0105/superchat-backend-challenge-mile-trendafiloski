package com.superchat.contact.service

import com.superchat.contact.model.Contact
import com.superchat.contact.model.ContactRequestBody
import com.superchat.contact.model.ContactResponseBody
import com.superchat.contact.repository.ContactRepository
import com.superchat.error.exceptions.NotFoundException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.util.*


internal class ContactServiceTest {
    private val contactRepository: ContactRepository = mock(ContactRepository::class.java)
    private lateinit var contactService: ContactService

    @BeforeEach
    internal fun setUp() {
        contactService = ContactService(contactRepository)
    }

    @Test
    internal fun `Should list all contacts` () {

        val contacts = listOf(Contact(1, "1", "1"), Contact(2, "2", "2"))
        `when`(contactRepository.findAll()).thenReturn(contacts)

        val allContacts = contactService.getAllContacts()

        assertEquals(listOf(ContactResponseBody(2,"2","2")), allContacts)
    }

    @Test
    internal fun `Should create contact`() {
        val contactRequestBody = ContactRequestBody("email", "name")
        `when`(contactRepository.save(Contact(null, "email", "name"))).thenReturn(Contact(1, "email", "name"))

        val contact = contactService.createContact(contactRequestBody)

        assertEquals(ContactResponseBody(1, "email", "name"), contact)
    }

    @Test
    internal fun `Should get contact by id`() {
        `when`(contactRepository.findById(1L)).thenReturn(Optional.of(Contact(1L, "email", "name")))

        val contact = contactService.getContactById(1L)

        assertEquals(Contact(1, "email", "name"), contact)
    }

    @Test
    internal fun `Should throw exception if contact cannot be found`() {
        `when`(contactRepository.findById(1L)).thenReturn(Optional.empty())
        assertThrows<NotFoundException> { contactService.getContactById(1L) }
    }
}
