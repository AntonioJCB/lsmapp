package com.example.lsmapp.senas

data class Sena(
    val id: Int,
    val nombre: String,
    val imagenUrl: String,
    val videoUrl: String? = null,
    val descripcion: String? = null
)

object SenasData {
    val senasMock = listOf(
        Sena(
            id = 1,
            nombre = "Pensar",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Pensar_Web.mp4",
            descripcion = "Acción de formar ideas y representaciones de la realidad en la mente."
        ),
        Sena(
            id = 2,
            nombre = "Platicar",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Platicar_Web.mp4",
            descripcion = "Conversar o charlar con una o más personas."
        ),
        Sena(
            id = 3,
            nombre = "Sentar",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Sentar_Web.mp4",
            descripcion = "Ponerse o estar en una posición de reposo sobre un asiento."
        ),
        Sena(
            id = 4,
            nombre = "Terminar",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Terminar_Web.mp4",
            descripcion = "Llegar al final de algo; concluir o finalizar."
        ),
        Sena(
            id = 5,
            nombre = "Trabajar",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Trabajar_Web.mp4",
            descripcion = "Realizar una actividad física o intelectual, generalmente a cambio de un salario."
        ),
        Sena(
            id = 6,
            nombre = "Vender",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Vender_Web.mp4",
            descripcion = "Traspasar a alguien por el precio convenido la propiedad de lo que se posee."
        ),
        Sena(
            id = 7,
            nombre = "Ver",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Ver_Web.mp4",
            descripcion = "Percibir con los ojos o con la inteligencia algo."
        ),
        Sena(
            id = 8,
            nombre = "Vivir",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Vivir_Web.mp4",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Tener vida; estar vivo."
        ),
        Sena(
            id = 9,
            nombre = "Amigo",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Persona que mantiene una relación de amistad con otra u otras."
        ),
        Sena(
            id = 10,
            nombre = "Comer",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Tomar alimento por la boca."
        ),
        Sena(
            id = 11,
            nombre = "Beber",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Ingerir un líquido."
        ),
        Sena(
            id = 12,
            nombre = "Dormir",
            imagenUrl = "https://via.placeholder.com/150",
            videoUrl = "https://raw.githubusercontent.com/AntonioJCB/videos/main/Dormir_Web.mp4",
            descripcion = "Estar en un estado de reposo, consistente en la inacción o suspensión de los sentidos y de todo movimiento voluntario."
        ),
        Sena(
            id = 13,
            nombre = "Escuela",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Establecimiento público donde se da a los niños la instrucción primaria."
        ),
        Sena(
            id = 14,
            nombre = "Trabajo",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Ocupación retribuida en una empresa, una institución, etc."
        ),
        Sena(
            id = 15,
            nombre = "Ayuda",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Acción y efecto de ayudar."
        ),
        Sena(
            id = 16,
            nombre = "Sentir",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Experimentar sensaciones producidas por causas externas o internas."
        ),
        Sena(
            id = 17,
            nombre = "Aprender",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Adquirir el conocimiento de algo por medio del estudio o de la experiencia."
        ),
        Sena(
            id = 18,
            nombre = "Jugar",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Hacer algo con alegría y con el solo fin de entretenerse o divertirse."
        ),
        Sena(
            id = 19,
            nombre = "Feliz",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "Que tiene felicidad o la causa."
        ),
        Sena(
            id = 20,
            nombre = "Triste",
            imagenUrl = "https://via.placeholder.com/150",
            descripcion = "De carácter o genio melancólico."
        )
    )
}