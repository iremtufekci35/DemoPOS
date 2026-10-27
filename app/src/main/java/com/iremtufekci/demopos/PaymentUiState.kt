package com.iremtufekci.demopos

data class PaymentUiState(
    val amount: String = "100.00",
    val isProcessing: Boolean = false,
    val message: String = "Ödeme Bekleniyor"
)
