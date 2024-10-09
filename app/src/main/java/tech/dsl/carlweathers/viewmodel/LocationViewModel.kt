package tech.dsl.carlweathers.viewmodel

import androidx.lifecycle.ViewModel
import tech.dsl.carlweathers.domain.repository.LocationRepository

class LocationViewModel(private val repository: LocationRepository) : ViewModel() {
    fun registerLocation(city: String, latitude: Double, longitude: Double) {
        repository.registerLocation(city, latitude, longitude)
    }
}