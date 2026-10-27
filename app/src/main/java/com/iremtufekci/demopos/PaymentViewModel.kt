package com.iremtufekci.demopos

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class PaymentViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow(PaymentUiState())

    val uiState: StateFlow<PaymentUiState> = _uiState.asStateFlow()

    fun onAmountChanged(value: String){
        _uiState.update {
            it.copy(amount = value)
        }
    }
    fun startPayment(){
        if(_uiState.value.isProcessing) return
        _uiState.update {
            it.copy(isProcessing = true,
                message = "Ödeme işleniyor")
        }
    }
}