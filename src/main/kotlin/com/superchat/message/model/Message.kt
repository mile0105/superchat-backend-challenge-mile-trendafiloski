package com.superchat.message.model

import com.superchat.contact.model.Contact
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "message")
data class Message(
    @Id
    val id: Long,
    val content: String,
    @OneToOne
    @JoinColumn(name = "sender_id")
    val sender: Contact,
    @OneToOne
    @JoinColumn(name = "recipientId")
    val recipientId: Contact,
)
