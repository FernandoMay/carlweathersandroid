package tech.dsl.carlweathers.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import tech.dsl.carlweathers.viewmodel.LocationViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationRegistrationScreen() {
    val viewModel: LocationViewModel = viewModel()
    var city by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Register Location", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = city,
                onValueChange = { city = it },
                label = { Text("City") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = latitude,
                onValueChange = { latitude = it },
                label = { Text("Latitude") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = longitude,
                onValueChange = { longitude = it },
                label = { Text("Longitude") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                viewModel.registerLocation(city, latitude.toDouble(),longitude.toDouble())
            }) {
                Text("Register")
            }
        }
    }
}