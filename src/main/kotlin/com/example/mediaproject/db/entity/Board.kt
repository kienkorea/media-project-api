package com.example.mediaproject.db.entity

import com.example.mediaproject.api.request.PatchBoardRequest
import com.example.mediaproject.api.request.PostBoardRequest
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    val createdAt : LocalDateTime = LocalDateTime.now()
    var updatedAt : LocalDateTime? = null

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var user: User

    lateinit var title: String
    lateinit var content: String
    var likeCount: Long = 0
    var commentCount: Long = 0

}
fun postOf(postBoardRequest: PostBoardRequest, user: User): Board{
    return Board().apply {
        this.user= user
        this.title = postBoardRequest.title
        this.content = postBoardRequest.content
    }
}

fun patchOf(board: Board, user: User, patchBoardRequest: PatchBoardRequest): Board{
    board.updatedAt = LocalDateTime.now()
    if(patchBoardRequest.title != null) board.title = patchBoardRequest.title
    if(patchBoardRequest.content != null) board.content = patchBoardRequest.content
    board.user = user
    return board
}
