package com.superchat.contact.service

import com.superchat.contact.model.ContactRequestBody
import com.superchat.contact.model.ContactResponseBody
import com.superchat.contact.repository.ContactRepository
import org.springframework.stereotype.Service

@Service
class ContactService(
    private val contactRepository: ContactRepository
) {
    fun getAllContacts(): List<ContactResponseBody> {
        return java.util.ArrayList()
    }

    fun createContact(contactRequestBody: ContactRequestBody): ContactResponseBody {
        return ContactResponseBody("")
    }
}