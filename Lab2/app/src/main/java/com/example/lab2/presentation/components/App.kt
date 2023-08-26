package com.example.lab2.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab2.presentation.viewmodels.AppState
import com.example.lab2.presentation.viewmodels.CompanyViewModel


@Composable
fun App() {
    val viewModel: CompanyViewModel = viewModel()
    val companyData by viewModel.companyData.observeAsState()
    val appState by viewModel.appState.observeAsState()

    when (appState) {
        AppState.LOADING -> {
            DotsPulsing()
        }
        AppState.COMPLETED -> {
            companyData?.let { companies ->
                CompaniesScrollView(companies = companies)
            }
        }
        AppState.ERROR -> {
            ErrorView()
        }
        else -> Unit
    }
}