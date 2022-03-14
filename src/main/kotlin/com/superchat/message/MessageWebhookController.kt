package com.superchat.message

import com.superchat.message.model.MessageResponseBody
import com.superchat.message.model.ReceiveMessageRequestBody
import com.superchat.message.service.MessageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/messages")
class MessageWebhookController(
    private val messageService: MessageService
) {
    @PostMapping("/external")
    fun receiveMessage(@RequestBody @Valid message: ReceiveMessageRequestBody): ResponseEntity<MessageResponseBody> {
        return ResponseEntity.ok(messageService.receiveMessage(message))
    }
}