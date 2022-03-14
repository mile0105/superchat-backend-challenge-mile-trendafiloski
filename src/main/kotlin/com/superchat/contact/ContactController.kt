package com.superchat.contact

import com.superchat.contact.model.ContactRequestBody
import com.superchat.contact.model.ContactResponseBody
import com.superchat.contact.service.ContactService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/api/v1/contacts"])
class ContactController(
    private val contactService: ContactService
    ) {

    @GetMapping
    fun getAllContacts() : ResponseEntity<List<ContactResponseBody>> {
        val allContacts = contactService.getAllContacts()
        return ResponseEntity.ok(allContacts)
    }

    @PostMapping
    fun createContact(@RequestBody @Valid contactRequestBody: ContactRequestBody) : ResponseEntity<ContactResponseBody> {
        return ResponseEntity.ok(contactService.createContact(contactRequestBody))
    }
}