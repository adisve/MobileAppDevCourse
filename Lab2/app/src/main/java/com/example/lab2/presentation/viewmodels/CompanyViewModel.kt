package com.example.lab2.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab2.data.CompanyService
import com.example.lab2.domain.models.network.Company

enum class AppState {
    LOADING,
    COMPLETED,
    ERROR
}

class CompanyViewModel: ViewModel() {

    private val companyService = CompanyService()
    private val documentId: String = "7CkcLLQKJ0nZ7GUf9bCO"

    private val _companyData = MutableLiveData<List<Company>?>()
    private val _appState = MutableLiveData<AppState>()

    val companyData: LiveData<List<Company>?> = _companyData
    val appState: LiveData<AppState> = _appState

    init {
        loadCompanyData()
    }

    private fun loadCompanyData() {
        _appState.value = AppState.LOADING
        companyService.fetchCompanyData(documentId)
            .addOnSuccessListener { companies ->
                if (companies != null) {
                    _companyData.value = companies
                    _appState.value = AppState.COMPLETED
                } else {
                    _appState.value = AppState.ERROR
                }
            }
            .addOnFailureListener {
                _appState.value = AppState.ERROR
            }
    }

}