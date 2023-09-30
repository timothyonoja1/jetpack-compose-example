package com.examples.jetpackexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConversationViewModel @Inject constructor(

) : ViewModel() {

    // Expose screen UI state
    private var _uiState = MutableStateFlow(
        ConversationUiState(
            isFetchingConversation = true, conversation = SampleData.conversationSample)
    )

    // Handle business logic
    fun getUiState(): StateFlow<ConversationUiState> {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { currentState ->
                currentState.copy(
                    isFetchingConversation = false,
                    conversation = SampleData.conversationSample
                )
            }
        }
        return _uiState.asStateFlow()
    }

    fun clear() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { currentState ->
                currentState.copy(
                    isFetchingConversation = false,
                    conversation = listOf()
                )
            }
        }
    }

    fun reload() {
        getUiState()
    }
}