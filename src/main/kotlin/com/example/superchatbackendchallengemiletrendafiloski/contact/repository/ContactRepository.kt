package com.example.superchatbackendchallengemiletrendafiloski.contact.repository

import com.example.superchatbackendchallengemiletrendafiloski.contact.model.ContactDbModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactRepository : CrudRepository<ContactDbModel, Long> {
}