package com.example.lsmapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lsmapp.senas.Sena
import com.example.lsmapp.senas.SenaCategory
import com.example.lsmapp.senas.SenasViewModel
import com.example.lsmapp.senas.SenaDetailDialog

@Composable
fun SenasScreen(
    viewModel: SenasViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onSenaClick: (Sena) -> Unit = {}
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val categories = viewModel.getCategories()
    val filteredSenas by viewModel.filteredSenas.collectAsState(initial = emptyList())

    var selectedSena by remember { mutableStateOf<Sena?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        // Barra de búsqueda
        SearchBar(
            query = searchQuery,
            onQueryChange = { viewModel.updateSearchQuery(it) },
            modifier = Modifier.padding(top = 16.dp, bottom = 12.dp)
        )

        // Filtros de categoría
        CategoryFilters(
            categories = categories,
            selectedCategory = selectedCategory,
            onCategorySelected = { viewModel.selectCategory(it) },
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Grid de señas
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(filteredSenas) { sena ->
                SenaCard(
                    sena = sena,
                    onClick = {
                        selectedSena = sena
                        onSenaClick(sena)
                    }
                )
            }
        }
    }

    selectedSena?.let { sena ->
        SenaDetailDialog(
            sena = sena,
            onDismiss = { selectedSena = null }
        )
    }
}

@Composable
private fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text("Buscar señas...") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Buscar"
            )
        },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(onClick = { onQueryChange("") }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Limpiar"
                    )
                }
            }
        },
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true
    )
}

@Composable
private fun CategoryFilters(
    categories: List<SenaCategory>,
    selectedCategory: SenaCategory?,
    onCategorySelected: (SenaCategory?) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Botón "Todas"
        item {
            CategoryChip(
                label = "Todas",
                isSelected = selectedCategory == null,
                onClick = { onCategorySelected(null) }
            )
        }

        // Botones de categorías
        items(categories) { category ->
            CategoryChip(
                label = category.nombre,
                isSelected = selectedCategory == category,
                onClick = { onCategorySelected(category) }
            )
        }
    }
}

@Composable
private fun CategoryChip(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        color = if (isSelected) Color(0xFF008080) else Color.White,
        tonalElevation = if (isSelected) 4.dp else 0.dp,
        shadowElevation = 2.dp
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            color = if (isSelected) Color.White else Color.DarkGray,
            fontSize = 14.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Composable
private fun SenaCard(
    sena: Sena,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFE8E8E8))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = sena.nombre,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                lineHeight = 14.sp
            )
        }
    }
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
private fun SenasScreenPreview() {
    SenasScreen()
}