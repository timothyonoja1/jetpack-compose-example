package com.examples.jetpackexample

data class ConversationUiState (
    val isFetchingConversation: Boolean,
    val conversation: List<Message> = listOf()
)