package com.superchat.message

import com.superchat.message.model.MessageResponseBody
import com.superchat.message.model.SendMessageRequestBody
import com.superchat.message.service.MessageService
import org.springframework.http.ResponseEntity
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Controller
import javax.validation.Valid

@Controller
class MessageController(
    private val messageService: MessageService
) {

    @MessageMapping("/chat")
    fun sendMessage(@Payload @Valid message: SendMessageRequestBody): ResponseEntity<MessageResponseBody> {
        return ResponseEntity.ok(messageService.sendMessage(message))
    }

}