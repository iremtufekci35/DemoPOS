package com.iremtufekci.demopos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PaymentScreen(viewModel: PaymentViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Column(modifier = Modifier.padding(24.dp)){
        OutlinedTextField(
            value = state.amount,
            onValueChange = viewModel::onAmountChanged,
            label = { Text("Tutar") }
        )
        Spacer(Modifier.height(16.dp))

        Text(state.message)

        Button(onClick = viewModel::startPayment, enabled = !state.isProcessing) {
            Text(
                if(state.isProcessing){
                    "İşleniyor"
                }
                else{
                    "Ödeme başlat"
                }
            )
        }

    }
}