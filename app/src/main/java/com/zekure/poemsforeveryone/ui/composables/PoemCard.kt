package com.zekure.poemsforeveryone.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zekure.poemsforeveryone.network.Poem
import com.zekure.poemsforeveryone.ui.theme.PoemsForEveryoneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoemCard(poem: Poem) {
    ElevatedCard(
        onClick = { /* Do something */ },
        modifier = Modifier
            .padding(8.dp)
            .size(height = 500.dp, width = 300.dp),
        colors = CardDefaults.cardColors()
    ) {
        Column(
            Modifier.padding(8.dp)
        ) {
            Text(text = poem.title, style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(10.dp))
            Divider()
            Text(text = poem.author, style = MaterialTheme.typography.bodyLarge)
            for (line in poem.lines) {
                Text(text = line, style = MaterialTheme.typography.bodySmall)
            }
            
        }

    }

}

@Preview
@Composable
fun PoemCardPreview() {
    PoemsForEveryoneTheme() {
        PoemCard(Poem("A day in my Life","William Shakespeare", listOf("When daisies pied, and violets blue,",
            "And lady-smocks all silver-white,",
            "And cuckoo-buds of yellow hue",
            "Do paint the meadows with delight,",
            "The cuckoo then, on every tree,",
            "Mocks married men, for thus sings he:",
            "'Cuckoo!",
            "Cuckoo, cuckoo!' O word of fear,",
            "Unpleasing to a married ear.",
            "When shepherds pipe on oaten straws,",
            "And merry larks are ploughmen's clocks,",
            "When turtles tread, and rooks, and daws,",
            "And maidens bleach their summer smocks,",
            "The cuckoo then, on every tree,",
            "Mocks married men, for thus sings he:",
            "'Cuckoo!",
            "Cuckoo, cuckoo!' O word of fear,",
            "Unpleasing to a married ear."),"33"))
    }
}