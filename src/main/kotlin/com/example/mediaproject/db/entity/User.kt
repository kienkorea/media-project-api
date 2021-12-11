package com.example.mediaproject.db.entity

import com.example.mediaproject.db.enumerable.UserRole
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class User: UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    val createdAt : LocalDateTime = LocalDateTime.now()
    var updatedAt : LocalDateTime? = null
    lateinit var loginPassWord: String

    @Column(unique = true)
    lateinit var name: String
    @Column(unique = true)
    lateinit var email: String
    @Column(unique = true)
    lateinit var phoneNumber: String
    var isDeleted: Boolean = false
    var deletedAt : LocalDateTime? = null

    var userRole: UserRole = UserRole.NONE
    var needChangePassword = false

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    var boardList: MutableList<Board> = mutableListOf()

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    var commentList: MutableList<Comment> = mutableListOf()

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return null
    }

    override fun getPassword(): String? {
        TODO("Not yet implemented")
    }

    override fun getUsername(): String {
        return name
    }

    override fun isAccountNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAccountNonLocked(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isCredentialsNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEnabled(): Boolean {
        return !this.isDeleted
    }
}
