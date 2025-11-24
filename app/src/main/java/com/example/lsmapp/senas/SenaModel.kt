package com.example.lsmapp.senas

data class Sena(
    val id: Int,
    val nombre: String,
    val imagenUrl: String,
    val videoUrl: String? = null,
    val descripcion: String? = null,
    val categoria: SenaCategory
)

enum class SenaCategory(val nombre: String) {
    VERBOS_COMUNES("Verbos Comunes"),
    ABECEDARIO("Abecedario"),
    ANIMALES("Animales")
}

object SenasData {
    val senasMock = listOf(
        // Verbos Comunes
        Sena(
            id = 1,
            nombre = "Pensar",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Pensar_Web.mp4",
            descripcion = "Acción de formar ideas y representaciones de la realidad en la mente.",
            categoria = SenaCategory.VERBOS_COMUNES
        ),
        Sena(
            id = 2,
            nombre = "Platicar",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Platicar_Web.mp4",
            descripcion = "Conversar o charlar con una o más personas.",
            categoria = SenaCategory.VERBOS_COMUNES
        ),
        Sena(
            id = 3,
            nombre = "Sentar",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Sentar_Web.mp4",
            descripcion = "Ponerse o estar en una posición de reposo sobre un asiento.",
            categoria = SenaCategory.VERBOS_COMUNES
        ),
        Sena(
            id = 4,
            nombre = "Terminar",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Terminar_Web.mp4",
            descripcion = "Llegar al final de algo; concluir o finalizar.",
            categoria = SenaCategory.VERBOS_COMUNES
        ),
        Sena(
            id = 5,
            nombre = "Trabajar",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Trabajar_Web.mp4",
            descripcion = "Realizar una actividad física o intelectual, generalmente a cambio de un salario.",
            categoria = SenaCategory.VERBOS_COMUNES
        ),
        Sena(
            id = 6,
            nombre = "Vender",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Vender_Web.mp4",
            descripcion = "Traspasar a alguien por el precio convenido la propiedad de lo que se posee.",
            categoria = SenaCategory.VERBOS_COMUNES
        ),
        Sena(
            id = 7,
            nombre = "Ver",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Ver_Web.mp4",
            descripcion = "Percibir con los ojos o con la inteligencia algo.",
            categoria = SenaCategory.VERBOS_COMUNES
        ),
        Sena(
            id = 8,
            nombre = "Vivir",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Vivir_Web.mp4",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Tener vida; estar vivo.",
            categoria = SenaCategory.VERBOS_COMUNES
        ),
        Sena(
            id = 10,
            nombre = "Comer",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Tomar alimento por la boca.",
            categoria = SenaCategory.VERBOS_COMUNES
        ),
        Sena(
            id = 11,
            nombre = "Beber",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Ingerir un líquido.",
            categoria = SenaCategory.VERBOS_COMUNES
        ),
        Sena(
            id = 12,
            nombre = "Dormir",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Dormir_Web.mp4",
            descripcion = "Estar en un estado de reposo, consistente en la inacción o suspensión de los sentidos y de todo movimiento voluntario.",
            categoria = SenaCategory.VERBOS_COMUNES
        ),
        Sena(
            id = 16,
            nombre = "Sentir",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Experimentar sensaciones producidas por causas externas o internas.",
            categoria = SenaCategory.VERBOS_COMUNES
        ),
        Sena(
            id = 17,
            nombre = "Aprender",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Adquirir el conocimiento de algo por medio del estudio o de la experiencia.",
            categoria = SenaCategory.VERBOS_COMUNES
        ),
        Sena(
            id = 18,
            nombre = "Jugar",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Hacer algo con alegría y con el solo fin de entretenerse o divertirse.",
            categoria = SenaCategory.VERBOS_COMUNES
        ),

        // Abecedario
        Sena(
            id = 100,
            nombre = "A",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Primera letra del abecedario en LSM",
            categoria = SenaCategory.ABECEDARIO
        ),
        Sena(
            id = 101,
            nombre = "B",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Segunda letra del abecedario en LSM",
            categoria = SenaCategory.ABECEDARIO
        ),
        Sena(
            id = 102,
            nombre = "C",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Tercera letra del abecedario en LSM",
            categoria = SenaCategory.ABECEDARIO
        ),
        Sena(
            id = 103,
            nombre = "D",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Cuarta letra del abecedario en LSM",
            categoria = SenaCategory.ABECEDARIO
        ),
        Sena(
            id = 104,
            nombre = "E",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Quinta letra del abecedario en LSM",
            categoria = SenaCategory.ABECEDARIO
        ),

        // Animales
        Sena(
            id = 200,
            nombre = "Perro",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Mamífero doméstico de la familia de los cánidos",
            categoria = SenaCategory.ANIMALES
        ),
        Sena(
            id = 201,
            nombre = "Gato",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Mamífero carnívoro de la familia de los félidos",
            categoria = SenaCategory.ANIMALES
        ),
        Sena(
            id = 202,
            nombre = "Pájaro",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Ave de pequeño tamaño",
            categoria = SenaCategory.ANIMALES
        ),
        Sena(
            id = 203,
            nombre = "Pez",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Animal vertebrado acuático",
            categoria = SenaCategory.ANIMALES
        ),
        Sena(
            id = 204,
            nombre = "Caballo",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Mamífero équido utilizado como animal de monta o carga",
            categoria = SenaCategory.ANIMALES
        )
    )
}