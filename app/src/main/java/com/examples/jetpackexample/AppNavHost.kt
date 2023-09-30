package com.examples.jetpackexample

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "conversation"
) {
    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route="conversation") {
            Conversation(
                onNavigateToConversationDetail = {
                    navController.navigate(route="conversationDetail")
                }
            )
        }
        composable(route="conversationDetail") {
            ConversationDetail(
                onNavigateToConversation = {
                    navController.navigate(route="conversation")
                }
            )
        }
    }
}