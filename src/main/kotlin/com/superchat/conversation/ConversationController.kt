package com.superchat.conversation

import com.superchat.conversation.model.service.ConversationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/api/v1/conversations")
class ConversationController(
    private val conversationService: ConversationService
) {

    @GetMapping("/my")
    fun getMyConversations() {

    }

}