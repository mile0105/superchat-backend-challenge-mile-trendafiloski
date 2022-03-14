package com.superchat.contact.model

import javax.persistence.*

@Entity
@Table(name = "contact")
data class Contact (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val email: String,
    val name: String
)
