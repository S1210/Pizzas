package com.mozio.pizzas.presentation.pizzas.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mozio.pizzas.domain.model.Pizza

@Composable
fun PizzaItem(
    modifier: Modifier = Modifier,
    pizza: Pizza,
    onCheckedChange: (pizza: Pizza) -> Unit
) {
    Card(modifier = modifier.clickable { onCheckedChange(pizza) }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = pizza.name
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = pizza.price.toString())
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = pizza.isSelected,
                onCheckedChange = null
            )
        }
    }
}