package com.example.mediaproject.db.repository

import com.example.mediaproject.db.entity.Comment
import com.example.mediaproject.db.entity.QComment
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class CommentRepositorySupport(
    private val jpaQueryFactory: JPAQueryFactory
) {
    private val qComment: QComment = QComment.comment

    fun findAllByUserIdOrderByCreatedAtDesc(userId: Long): List<Comment>{
        return jpaQueryFactory.select(qComment)
            .from(qComment)
            .where(qComment.user.id.eq(userId))
            .orderBy(qComment.id.desc())
            .fetch()
    }

}
