package com.superchat.contact.service

import com.superchat.contact.model.ContactRequestBody
import com.superchat.contact.model.ContactResponseBody
import com.superchat.contact.repository.ContactRepository
import com.superchat.contact.util.toDbEntityForInsertion
import com.superchat.contact.util.toResponseBody
import org.springframework.stereotype.Service

@Service
class ContactService(
    private val contactRepository: ContactRepository
) {
    fun getAllContacts(): List<ContactResponseBody> {
        return contactRepository.findAll().iterator().asSequence()
            // this is to prevent showing own contact, in a real world application we would have proper login/register and filtering in the db
            .filter { it.id != 1L }
            .map { it.toResponseBody() }
            .toList()
    }

    fun createContact(contactRequestBody: ContactRequestBody): ContactResponseBody {
        val savedContact = contactRepository.save(contactRequestBody.toDbEntityForInsertion())
        return savedContact.toResponseBody()
    }
}