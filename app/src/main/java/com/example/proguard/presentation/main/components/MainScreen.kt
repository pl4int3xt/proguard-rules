package com.example.proguard.presentation.main.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proguard.presentation.main.MainViewState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(state: MutableState<MainViewState>) {
    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            if (state.value.isLoading){
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            if (state.value.message.isNotEmpty()){
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = state.value.message
                )
            }

            if (state.value.posts.isNotEmpty()){
                LazyColumn() {
                    items(state.value.posts) { post ->
                        OutlinedCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(text = post.title)
                            Text(text = post.body)
                        }
                    }
                }
            }
        }
    }
}