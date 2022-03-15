package com.superchat.messagetemplate.model

import com.superchat.contact.model.Contact
import javax.persistence.*

@Entity
@Table(name = "message_template")
data class MessageTemplate(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val template: String,
    @OneToOne
    @JoinColumn(name = "editor_id")
    val editor: Contact,

    //NOTE: for now I leave these comma separated. In a real world db, I would store them as a list
    val parameters: String,


    )