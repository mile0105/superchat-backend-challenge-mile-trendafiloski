package com.superchat.message.repository

import com.superchat.message.model.MessageDbModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository: CrudRepository<Long, MessageDbModel> {

}