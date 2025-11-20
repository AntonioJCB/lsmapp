package com.example.lsmapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lsmapp.R
import com.example.lsmapp.ui.theme.Accent
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.PanTool
import com.example.lsmapp.ui.theme.LsmappTheme

enum class NavBarItem { LIST, SIGNS, PROFILE }

@Composable
fun NavBar(
    selectedItem: NavBarItem,
    onItemSelected: (NavBarItem) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(Color.White)
            .padding(vertical = 12.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavBarItemButton(
            isSelected = selectedItem == NavBarItem.LIST,
            onClick = { onItemSelected(NavBarItem.LIST) },
            label = "List"
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.List,
                contentDescription = "List",
                modifier = Modifier.size(24.dp),
                tint = if (selectedItem == NavBarItem.LIST) Accent else Color.Black
            )
        }

        NavBarItemButton(
            isSelected = selectedItem == NavBarItem.SIGNS,
            onClick = { onItemSelected(NavBarItem.SIGNS) },
            label = "Signs"
        ) {

            Icon(
                imageVector = Icons.Filled.PanTool,
                contentDescription = "Signs",
                modifier = Modifier.size(24.dp),
                tint = if (selectedItem == NavBarItem.SIGNS) Accent else Color.Black
            )

        }

        NavBarItemButton(
            isSelected = selectedItem == NavBarItem.PROFILE,
            onClick = { onItemSelected(NavBarItem.PROFILE) },
            label = "Profile"
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                modifier = Modifier.size(24.dp),
                tint = if (selectedItem == NavBarItem.PROFILE) Accent else Color.Black
            )
        }
    }
}

@Composable
private fun NavBarItemButton(
    isSelected: Boolean,
    onClick: () -> Unit,
    label: String,
    icon: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier.size(28.dp),
            contentAlignment = Alignment.Center
        ) {
            icon()
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
            color = if (isSelected) Accent else Color.Black
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF47525E)
@Composable
fun NavBarPreview() {
    LsmappTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF47525E))
                .padding(16.dp)
        ) {
            NavBar(selectedItem = NavBarItem.SIGNS) {}
        }
    }
}
