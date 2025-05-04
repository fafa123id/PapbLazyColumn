package com.example.papblazycolumn.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.papblazycolumn.model.User
import com.example.papblazycolumn.retrofit.Users
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response = Users.apiService.getUsers()
                _users.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}
