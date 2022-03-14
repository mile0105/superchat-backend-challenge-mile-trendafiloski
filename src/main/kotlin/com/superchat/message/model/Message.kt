package com.superchat.message.model

import com.superchat.contact.model.Contact
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "message")
data class Message(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val content: String,
    val time: LocalDateTime,
    @Enumerated(EnumType.STRING)
    val channel: Channel,
    @OneToOne
    @JoinColumn(name = "sender_id")
    val sender: Contact,
    @OneToOne
    @JoinColumn(name = "recipient_id")
    val recipient: Contact,
)
