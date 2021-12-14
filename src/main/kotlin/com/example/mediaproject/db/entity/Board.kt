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

    lateinit var content: String

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var user: User

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var commentList: MutableList<Comment> = mutableListOf()

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var likeList: MutableList<BoardLike> = mutableListOf()

}
fun postOf(postBoardRequest: PostBoardRequest, user: User): Board{
    return Board().apply {
        this.user= user
        this.content = postBoardRequest.content
    }
}

fun patchOf(board: Board, patchBoardRequest: PatchBoardRequest): Board{
    board.updatedAt = LocalDateTime.now()
    board.content = patchBoardRequest.content
    return board
}
