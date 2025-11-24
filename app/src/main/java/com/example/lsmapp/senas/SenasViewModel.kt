package com.example.lsmapp.senas

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine

class SenasViewModel : ViewModel() {

    private val _senas = MutableStateFlow<List<Sena>>(emptyList())
    val senas = _senas.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow<SenaCategory?>(null)
    val selectedCategory = _selectedCategory.asStateFlow()

    // Flow combinado para filtrado reactivo
    val filteredSenas = combine(
        _senas,
        _searchQuery,
        _selectedCategory
    ) { senas, query, category ->
        var filtered = senas

        // Filtrar por categoría
        category?.let {
            filtered = filtered.filter { sena -> sena.categoria == it }
        }

        // Filtrar por búsqueda
        if (query.isNotBlank()) {
            filtered = filtered.filter { sena ->
                sena.nombre.contains(query, ignoreCase = true)
            }
        }

        filtered
    }

    init {
        loadSenas()
    }

    private fun loadSenas() {
        _senas.value = SenasData.senasMock
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun selectCategory(category: SenaCategory?) {
        _selectedCategory.value = category
    }

    fun getCategories(): List<SenaCategory> {
        return SenaCategory.values().toList()
    }
}