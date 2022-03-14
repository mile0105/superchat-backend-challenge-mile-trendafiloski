package com.superchat.contact.repository

import com.superchat.contact.model.Contact
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactRepository : CrudRepository<Contact, Long> {
}