package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel()  {
    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> =  _uiState.asStateFlow()


    fun updateDesertSold(){
        desertShowIndex(_uiState.value.dessertsSold)
            _uiState.update { currentState->
                currentState.copy(
                    dessertsSold =  _uiState.value.dessertsSold+1,
                    revenue = _uiState.value.revenue.plus(dessertList[_uiState.value.currentDesertIndex].price),
                )
            }

    }

    private fun desertShowIndex(soldDesert: Int) {
        var ans =0
        for (i in 0..dessertList.size) {
            if (soldDesert >= dessertList[i].startProductionAmount) {
                ans = i

            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }
        _uiState.update { currentState->
            currentState.copy(
                currentDesertIndex = ans
            )
        }
    }



}