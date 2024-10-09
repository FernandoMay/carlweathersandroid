package tech.dsl.carlweathers.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import tech.dsl.carlweathers.viewmodel.WeatherViewModel

@Composable
fun WeatherStatusScreen() {
    val viewModel: WeatherViewModel = viewModel()
    val locations = viewModel.locations.value

    LazyColumn {
        items(locations) { location ->
            Text(text = "${location.city}: ${location.latitude}, ${location.longitude}°C, ${location.registrationDate}")
            // Add weather icon and click handling for detailed view
        }
    }
}