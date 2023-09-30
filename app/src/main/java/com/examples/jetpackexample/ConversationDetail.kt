package com.examples.jetpackexample

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.examples.jetpackexample.ui.theme.JetpackExampleTheme

@Composable
fun ConversationDetail(onNavigateToConversation: () -> Unit) {
    Column {
        Text("NavigationWorked!")
        Button(onClick = onNavigateToConversation) {
            Text("Navigate")
        }
    }
}


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewConversationDetail() {
    JetpackExampleTheme() {
        ConversationDetail(onNavigateToConversation = {})
    }
}