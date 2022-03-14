package com.superchat.contact.util

import com.superchat.contact.model.Contact
import com.superchat.contact.model.ContactRequestBody
import com.superchat.contact.model.ContactResponseBody

fun Contact.toResponseBody(): ContactResponseBody {
    return ContactResponseBody(id = id!!, email = email, name = name)
}

fun ContactRequestBody.toDbEntityForInsertion(): Contact {
    return Contact(email = email, name = name, id = null)
}