package com.example.mediaproject.db.repository

import com.example.mediaproject.db.entity.Board
import com.example.mediaproject.db.entity.QBoard
import com.example.mediaproject.db.entity.QUser
import com.querydsl.core.BooleanBuilder
import com.querydsl.jpa.impl.JPAQuery
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class BoardRepositorySupport(
    private val jpaQueryFactory: JPAQueryFactory
) {
    private val qBoard: QBoard = QBoard.board
    private val qUser: QUser = QUser.user

    fun findAllBoard(q: String?, sortBy: String): List<Board> {
        val where = BooleanBuilder()
        if(q != null){
            where.and(qBoard.content.contains(q)
                .or(qUser.name.contains(q)))
        }
        val query: JPAQuery<Board> = jpaQueryFactory.select(qBoard)
            .from(qBoard)
            .where(where)
        if(sortBy == "likeCount") query.orderBy(qBoard.commentList.size().desc())
        else if(sortBy == "createdAt") query.orderBy(qBoard.createdAt.desc())
        return query.fetch()
    }
}
