package com.superchat.message.repository

import com.superchat.message.model.Message
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository: CrudRepository<Message, Long> {

}