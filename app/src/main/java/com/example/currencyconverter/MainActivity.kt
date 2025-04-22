package com.example.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.currencyconverter.ui.theme.CurrencyConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CurrencyConverterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CurrencyConverterApp()
                }
            }
        }
    }
}

@Composable
fun CurrencyConverterApp() {
    val currencyList = listOf("IDR", "USD", "EUR", "JPY", "KRW", "RUB", "GBP", "AUD", "MYR", "SGD", "CNY")
    val rates = mapOf(
        "IDR" to 1.0,
        "USD" to 1 / 16772.0,       // ≈ 0.00005963
        "EUR" to 1 / 19142.0,       // ≈ 0.00005225
        "JPY" to 1 / 117.79,        // ≈ 0.008489
        "KRW" to 1 / 11.80,         // ≈ 0.08475
        "RUB" to 1 / 200.79,        // ≈ 0.00498
        "GBP" to 1 / 22084.20,      // ≈ 0.00004528
        "AUD" to 1 / 10611.0,       // ≈ 0.00009425
        "MYR" to 1 / 3802.53,       // ≈ 0.000263
        "SGD" to 1 / 12787.90,       // ≈ 0.0000782
        "CNY" to 1 / 2314.0
    )

    var amountInput by remember { mutableStateOf("") }
    var fromCurrency by remember { mutableStateOf("IDR") }
    var toCurrency by remember { mutableStateOf("USD") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Currency Converter", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        OutlinedTextField(
            value = amountInput,
            onValueChange = { amountInput = it },
            label = { Text("Enter amount") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CurrencyDropdown("From", currencyList, fromCurrency) {
                fromCurrency = it
            }

            CurrencyDropdown("To", currencyList, toCurrency) {
                toCurrency = it
            }
        }

        Button(
            onClick = {
                val amount = amountInput.toDoubleOrNull()
                if (amount != null) {
                    val fromRate = rates[fromCurrency] ?: 1.0
                    val toRate = rates[toCurrency] ?: 1.0
                    val converted = amount * (toRate / fromRate)
                    result = "%.2f $toCurrency".format(converted)
                } else {
                    result = "Invalid input"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Convert")
        }

        if (result.isNotEmpty()) {
            Text("Result: $result", fontSize = 20.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun CurrencyDropdown(
    label: String,
    options: List<String>,
    selected: String,
    onSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(label, fontWeight = FontWeight.SemiBold)
        Box {
            OutlinedButton(
                onClick = { expanded = true },
                modifier = Modifier.width(150.dp)
            ) {
                Text(selected)
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                options.forEach { currency ->
                    DropdownMenuItem(
                        text = { Text(currency) },
                        onClick = {
                            onSelected(currency)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CurrencyConverterPreview() {
    CurrencyConverterTheme {
        CurrencyConverterApp()
    }
}
