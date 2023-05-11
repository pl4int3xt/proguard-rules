package com.example.proguard.presentation.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proguard.common.Resource
import com.example.proguard.domain.use_case.GetAllPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllPostsUseCase: GetAllPostsUseCase
): ViewModel() {

    private val _state = mutableStateOf(MainViewState())
    val state = _state
    init {
        getAllPostsUseCase().onEach { result ->
            when(result){
                is Resource.Error -> {
                    _state.value = MainViewState(message = result.message ?: "unknown error")
                }
                is Resource.Loading -> {
                    _state.value = MainViewState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = MainViewState(posts = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}