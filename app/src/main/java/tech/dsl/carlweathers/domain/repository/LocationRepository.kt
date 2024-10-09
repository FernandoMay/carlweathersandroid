package tech.dsl.carlweathers.domain.repository

import  tech.dsl.carlweathers.domain.model.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class LocationRepository {private val locationsFlow = MutableStateFlow<List<Location>>(emptyList())

    fun getLocations(): Flow<List<Location>> = locationsFlow

    fun registerLocation(city: String, latitude: Double, longitude: Double) {
        val newLocation = Location(
            id = generateLocationId(), // Implement ID generation logic
            city = city,
            latitude = latitude,
            longitude = longitude,
            registrationDate = System.currentTimeMillis()
        )
        val updatedLocations = locationsFlow.value + newLocation
        locationsFlow.value = updatedLocations
    }// Implement other functions for updating, deleting locations, etc.

    private fun generateLocationId(): Int {
        // Implement logic to generate unique location IDs
        return locationsFlow.value.size + 1 // Simple example
    }
}