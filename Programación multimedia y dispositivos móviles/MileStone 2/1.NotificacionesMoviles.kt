fun main() {
    val notificacionesMañana = 51
    val notificacionesTarde = 135

    mostrarResumenNotificaciones(notificacionesMañana)
    mostrarResumenNotificaciones(notificacionesTarde)
}

fun mostrarResumenNotificaciones(cantidadDeMensajes: Int) {
    if (cantidadDeMensajes < 100) {
        println("Tienes ${cantidadDeMensajes} notificaciones.")
    } else {
        println("¡Tu teléfono va un poco mal! Tienes 99+ notificaciones.")
    }
}