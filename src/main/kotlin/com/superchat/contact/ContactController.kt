package com.superchat.contact

import com.superchat.contact.model.ContactRequestBody
import com.superchat.contact.model.ContactResponseBody
import com.superchat.contact.service.ContactService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/v1/contacts"])
class ContactController(
    private val contactService: ContactService
    ) {

    @GetMapping
    fun getAllContacts() : ResponseEntity<List<ContactResponseBody>> {
        return ResponseEntity.ok(contactService.getAllContacts())
    }

    @PostMapping
    fun createContact(@RequestBody contactRequestBody: ContactRequestBody) : ResponseEntity<ContactResponseBody> {
        return ResponseEntity.ok(contactService.createContact(contactRequestBody))
    }
}