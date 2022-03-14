package com.superchat.contact.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "contact")
data class Contact (
    @Id
    val id: Long,
    val email: String,
    val name: String
)
