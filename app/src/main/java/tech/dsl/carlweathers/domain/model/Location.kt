package tech.dsl.carlweathers.domain.model

data class Location(
    val id: Int,
    val city: String,
    val latitude: Double,
    val longitude: Double,
    val registrationDate: Long // Store as timestamp
)