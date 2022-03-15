package com.superchat.messagetemplate.repository

import com.superchat.messagetemplate.model.MessageTemplate
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageTemplateRepository : JpaRepository<MessageTemplate, Long>