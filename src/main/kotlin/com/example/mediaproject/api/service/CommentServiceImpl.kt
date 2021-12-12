package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.CommentRequest
import com.example.mediaproject.api.response.CommentResponse
import com.example.mediaproject.api.response.commentResponseOf
import com.example.mediaproject.common.exception.BadRequestException
import com.example.mediaproject.db.entity.Board
import com.example.mediaproject.db.entity.Comment
import com.example.mediaproject.db.entity.User
import com.example.mediaproject.db.entity.of
import com.example.mediaproject.db.repository.BoardRepository
import com.example.mediaproject.db.repository.CommentRepository
import com.example.mediaproject.db.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
class CommentServiceImpl(
    private val userRepository: UserRepository,
    private val boardRepository: BoardRepository,
    private val commentRepository: CommentRepository
) : CommentService {

    @Transactional
    override fun postComment(boardId: Long, userId: Long, commentRequest: CommentRequest): CommentResponse {
        val foundUser: User = userRepository.findById(userId)
            .orElseThrow { throw BadRequestException("유저 정보를 찾을 수 없습니다. -> $userId") }

        val foundBoard: Board = boardRepository.findById(boardId)
            .orElseThrow { throw BadRequestException("보드 정보를 찾을 수 없습니다. -> $boardId") }

        val comment: Comment = of(foundUser, foundBoard, commentRequest)
        return commentResponseOf(commentRepository.save(comment))
    }

    @Transactional
    override fun patchComment(commentId: Long, userId: Long, commentRequest: CommentRequest): CommentResponse {
        val foundComment: Comment = commentRepository.findById(commentId).orElseThrow { throw BadRequestException("댓글 정보를 찾을 수 없습니다. -> $commentId") }
        foundComment.apply {
            this.updatedAt = LocalDateTime.now()
            this.content = commentRequest.content
        }
        return commentResponseOf(commentRepository.save(foundComment))
    }

    override fun deleteComment(commentId: Long, userId: Long): Boolean {
        val foundComment: Comment = commentRepository.findById(commentId)
            .orElseThrow { throw BadRequestException("댓글 정보를 찾을 수 없습니다. -> $commentId") }
        commentRepository.delete(foundComment)
        return !commentRepository.existsById(foundComment.id)
    }
}