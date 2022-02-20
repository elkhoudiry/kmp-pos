package com.elkhoudiry.ui.utils.tables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.elkhoudiry.ui.helpers.HorizontalScrollbar
import com.elkhoudiry.ui.helpers.VerticalScrollbar
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor

@Composable
fun DynamicTable(
    titles: List<String>,
    contents: Map<String, List<Any>>,
) {
    val lengths = remember {
        calculateWeights(
            titles,
            contents
        )
    }
    val weights = remember { lengths.map { it.toFloat() / lengths.sum() } }

    val verticalScrollState = rememberLazyListState(0)
    val horizontalScrollState = rememberScrollState(0)

    Box {
        LazyColumn(
            Modifier
                .horizontalScroll(horizontalScrollState)
                .padding(end = 12.dp),
            verticalScrollState
        ) {
            item {
                Row(
                    Modifier
                        .background(Color.Gray)
                        .height(IntrinsicSize.Min)
                ) {
                    for (i in titles.indices) {
                        TableCell(
                            text = titles[i],
                            width = lengths[i],
                            weight = weights[i]
                        )
                    }
                }
            }

            for (i in 0 until contents[titles[0]]?.size!!) {
                val rowTexts = titles.map { contents[it]?.get(i) }

                item {
                    Row(
                        Modifier
                            .background(AppTheme.colors.surface.toColor())
                            .height(IntrinsicSize.Min)
                    ) {

                        for (j in rowTexts.indices) {

                            if (rowTexts[j] !is Boolean && rowTexts[j] != null) {
                                TableCell(
                                    text = rowTexts[j].toString(),
                                    width = lengths[j],
                                    weight = weights[j]
                                )
                            } else if (rowTexts[j] is Boolean) {
                                TableCell(
                                    boolean = rowTexts[j] as Boolean,
                                    width = lengths[j],
                                    weight = weights[j]
                                )
                            } else {
                                TableCell(
                                    text = "NaN",
                                    width = lengths[j],
                                    weight = weights[j]
                                )
                            }
                        }
                    }
                }
            }
        }

        VerticalScrollbar(
            modifier = Modifier.align(Alignment.CenterEnd),
            state = verticalScrollState
        )

        HorizontalScrollbar(
            modifier = Modifier.align(Alignment.BottomStart),
            state = horizontalScrollState
        )
    }
}

@Composable
fun TableCell(
    text: String,
    weight: Float,
    width: Int,
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .border(
                1.dp,
                Color.Black
            )
            .width((width * 15).dp)
            .padding(8.dp),
        contentAlignment = Alignment.CenterStart
    ) {

        Text(
            text = text,
            color = AppTheme.colors.onSurface.toColor(),
            style = AppTheme.type.body1
        )
    }
}

@Composable
fun TableCell(
    boolean: Boolean,
    weight: Float,
    width: Int,
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .border(
                1.dp,
                Color.Black
            )
            .width((width * 15).dp)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Checkbox(
            checked = boolean,
            onCheckedChange = null,
            modifier = Modifier.clickable { },
            colors = CheckboxDefaults.colors(checkedColor = AppTheme.colors.primary.toColor())
        )
    }
}

private fun calculateWeights(
    titles: List<String>,
    contents: Map<String, List<Any>>,
): List<Int> {
    val lengths = titles
        .map { it.length }
        .toMutableList()

    for (i in titles.indices) {
        val colTitle = titles[i]
        val colContents = contents[colTitle]

        var largest = colTitle.length

        for (content in colContents ?: listOf()) {
            val contentLength = content.toString().length

            if (contentLength > largest) {
                largest = contentLength
            }
        }

        lengths[i] = largest
    }

    return lengths
}
