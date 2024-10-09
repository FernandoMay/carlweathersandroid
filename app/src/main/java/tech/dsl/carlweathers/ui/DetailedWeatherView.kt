package tech.dsl.carlweathers.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import tech.dsl.carlweathers.domain.model.Weather

@Composable
fun DetailedWeatherView(weather: Weather) {
    Text(text = "Temperature: ${weather.temperature}°C")
    Text(text = "Description: ${weather.description}")
    // Add more detailed weather information and icon
}