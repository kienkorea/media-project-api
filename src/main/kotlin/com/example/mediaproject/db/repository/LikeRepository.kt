package com.example.mediaproject.db.repository

import com.example.mediaproject.db.entity.BoardLike
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LikeRepository: JpaRepository<BoardLike, Long> {

}
