package com.example.mediaproject.db.repository

import com.example.mediaproject.db.entity.Board
import com.example.mediaproject.db.entity.QBoard
import com.example.mediaproject.db.entity.QBoardLike
import com.example.mediaproject.db.entity.QUser
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

}
