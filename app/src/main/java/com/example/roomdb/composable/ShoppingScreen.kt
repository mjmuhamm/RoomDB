package com.example.roomdb.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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

    val items by viewModel.items.collectAsStateWithLifecycle()

    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }


    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()) {

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Enter name here") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, bottom = 0.dp, end = 16.dp, top = 16.dp)
            )

            OutlinedTextField(
                value = price,
                onValueChange = { price = it },
                label = { Text("Enter price here") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, bottom = 0.dp, end = 16.dp, top = 16.dp)
            )

            OutlinedTextField(
                value = quantity,
                onValueChange = { quantity = it },
                label = { Text("Enter quantity here") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, bottom = 0.dp, end = 16.dp, top = 16.dp)
            )

            Button(onClick = {
                viewModel.addItem(name, price, quantity)
                name = ""; price = ""; quantity = ""
            }, Modifier.padding(16.dp)) {
                Text("Add item")
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
            ) {
                items(items) { item ->
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)) {
                        ShoppingItemRow(item, onToggle = {viewModel.toggleBought(item)}, onDelete = {viewModel.deleteItem(item)})
                    }
                }

            }
        }
    }

    }

@Composable
fun ShoppingItemRow(item: ShoppingItem, onToggle: () -> Unit, onDelete : () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "$${item.price} * ${item.quantity}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
            }

                Checkbox(
                    checked = item.isBought,
                    onCheckedChange = { onToggle() }
                )

                IconButton(onClick = onDelete) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                }

        }
    }
}