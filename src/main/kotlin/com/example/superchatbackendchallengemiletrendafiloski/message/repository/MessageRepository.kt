package com.example.superchatbackendchallengemiletrendafiloski.message.repository

import com.example.superchatbackendchallengemiletrendafiloski.message.model.MessageDbModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository: CrudRepository<Long, MessageDbModel> {

}