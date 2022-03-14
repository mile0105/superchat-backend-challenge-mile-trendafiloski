package com.superchat.conversation

import com.superchat.conversation.model.ConversationResponseBody
import com.superchat.conversation.service.ConversationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/v1/conversations"])
class ConversationController(
    private val conversationService: ConversationService
) {

    @GetMapping("/contact/{id}")
    fun getPreviousConversations(
        @PathVariable(
            name = "id",
            required = true
        ) id: Long
    ): ResponseEntity<ConversationResponseBody> {
        return ResponseEntity.ok(conversationService.getPreviousConversationsFromContact(id))
    }

}