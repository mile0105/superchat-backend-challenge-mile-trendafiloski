package com.superchat.messagetemplate

import com.superchat.contact.service.ContactService
import com.superchat.messagetemplate.model.MessageTemplateCreationRequestBody
import com.superchat.messagetemplate.model.MessageTemplateResponseBody
import com.superchat.messagetemplate.service.MessageTemplateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/templates")
class MessageTemplateController(
    private val messageTemplateService: MessageTemplateService,
) {

    @PostMapping
    fun postTemplate(@Valid @RequestBody template: MessageTemplateCreationRequestBody): ResponseEntity<MessageTemplateResponseBody> {
        val response = messageTemplateService.addMessageTemplate(template)
        return ResponseEntity.ok(response)
    }
}