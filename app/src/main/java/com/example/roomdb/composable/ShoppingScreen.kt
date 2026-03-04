package com.example.roomdb.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.roomdb.entities.ShoppingItem
import com.example.roomdb.viewModel.ShoppingViewModel
//
@Composable
//@Preview(showBackground = true)
fun ShoppingScreen(modifier: Modifier, viewModel: ShoppingViewModel) {

    val shoppingItems by viewModel.items.collectAsStateWithLifecycle()


    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()) {

            OutlinedTextField(
                value = "",
                onValueChange = { "" },
                label = { Text("Enter name here") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, bottom = 0.dp, end = 16.dp, top = 16.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = { "" },
                label = { Text("Enter price here") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, bottom = 0.dp, end = 16.dp, top = 16.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = { "" },
                label = { Text("Enter quantity here") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, bottom = 0.dp, end = 16.dp, top = 16.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .heightIn(max = 200.dp)
                    .border(width = 2.dp, color = Color.Black)
            ) {
                items(shoppingItems.size) { item ->
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)) {
                        Text(
                            text = shoppingItems[item].name,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "${shoppingItems[item].price}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.secondary
                        )

                        Text(
                            text = "${shoppingItems[item].quantity}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.secondary
                        )

                        Text(
                            text = "${shoppingItems[item].isBought}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }

            }
        }


    }



}