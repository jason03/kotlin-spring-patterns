package net.zeotrope.patterns.builder.model

import java.util.UUID

data class User(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String
)
