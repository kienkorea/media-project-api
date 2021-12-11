package com.example.mediaproject.db.repository

import com.example.mediaproject.db.entity.*
import com.querydsl.core.BooleanBuilder
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class UserRepositorySupport(
    private val jpaQueryFactory: JPAQueryFactory
) {
    private val qUser: QUser = QUser.user
    private val qBoard: QBoard = QBoard.board
    private val qBoardLike: QBoardLike = QBoardLike.boardLike

    fun getMyLikeBoardList(userId: Long): List<Board> {
        return jpaQueryFactory.select(qBoard)
            .from(qBoardLike)
            .leftJoin(qBoardLike.board, qBoard)
            .leftJoin(qBoardLike.user, qUser)
            .where(qUser.id.eq(userId))
            .fetch()
    }

    fun getAllUser(q: String?): List<User> {
        val where = BooleanBuilder()
        if(q != null) where.and(qUser.name.contains(q))
        return jpaQueryFactory.select(qUser)
            .from(qUser)
            .where(where)
            .fetch()
    }


}
