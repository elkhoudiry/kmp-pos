package com.elkhoudiry.ui.utils.navbars

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkhoudiry.domain.navigation.models.NavDestination
import com.elkhoudiry.presentation.components.navbars.NavBarState
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor
import com.elkhoudiry.ui.utils.spacing.SmallSpacerHorizontal

@Composable
fun TopNavBar(
    modifier: Modifier, state: NavBarState, onNav: (to: NavDestination) -> Unit,

    ) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(text = "القائمة", style = AppTheme.type.h1, color = AppTheme.colors.onBackground.toColor())

        SmallSpacerHorizontal()

        for (item in state.items) {
            Button(
                modifier = Modifier.height(AppTheme.dimens.navItemHeight.dp), onClick = {
                    onNav(item.destination)
                }, enabled = item.enabled
            ) {
                Text(
                    text = item.title,
                )
            }

            SmallSpacerHorizontal()
        }
    }
}
