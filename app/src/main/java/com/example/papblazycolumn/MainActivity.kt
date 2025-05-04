package com.example.papblazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Preview
import com.example.papblazycolumn.model.User
import com.example.papblazycolumn.ui.theme.PapbLazyColumnTheme
import com.example.papblazycolumn.view.allUser
import com.example.papblazycolumn.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PapbLazyColumnTheme {
                val userViewModel: UserViewModel = viewModel()
                val userList = userViewModel.users.collectAsState().value

                // Pakai composable buatanmu
                allUser(listUser = userList)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PapbLazyColumnTheme {
        allUser(
            listUser = listOf(
                User(1, "Preview User", "username", "preview@example.com")
            )
        )
    }
}