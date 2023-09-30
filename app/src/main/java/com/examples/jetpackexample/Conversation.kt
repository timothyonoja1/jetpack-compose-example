package com.examples.jetpackexample

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.examples.jetpackexample.ui.theme.JetpackExampleTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Conversation(
    viewModel: ConversationViewModel = viewModel(),
    onNavigateToConversationDetail: () -> Unit
) {
    val uiState by viewModel.getUiState().collectAsState()

    Column {
        Row {
            Button(onClick = { viewModel.clear() }) {
                Text("Clear")
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(onClick = { viewModel.reload() }) {
                Text("Reload")
            }
            Button(onClick =  onNavigateToConversationDetail ) {
                Text("Navigate")
            }
        }

        LazyColumn {
            items(uiState.conversation) { message ->
                MessageCard(message, onMessageCardClicked = onNavigateToConversationDetail)
            }
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
fun PreviewConversation() {
    JetpackExampleTheme() {
        Conversation(onNavigateToConversationDetail = { })
    }
}