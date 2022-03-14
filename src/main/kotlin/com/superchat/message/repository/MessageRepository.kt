package com.superchat.message.repository

import com.superchat.message.model.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository: JpaRepository<Message, Long> {

    @Query(value = "select * from message m " +
            "where (m.recipient_id = :firstContact and m.sender_id = :secondContact) or " +
            "(m.recipient_id = :secondContact and m.sender_id = :firstContact)" +
            "order by m.time desc", nativeQuery = true)
    fun findPreviousMessagesBetweenTwoContacts(
        @Param("firstContact") firstContact: Long,
        @Param("secondContact") secondContact: Long,
    ): List<Message>
}