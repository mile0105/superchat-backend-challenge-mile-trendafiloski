package com.superchat.contact.repository

import com.superchat.contact.model.ContactDbModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactRepository : CrudRepository<ContactDbModel, Long> {
}