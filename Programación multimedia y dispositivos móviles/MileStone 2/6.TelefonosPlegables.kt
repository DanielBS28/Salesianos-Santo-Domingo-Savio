open class Telefono(var luzPantallaEncendida: Boolean = false) {
    open fun encender() {
        luzPantallaEncendida = true
    }

    fun apagar() {
        luzPantallaEncendida = false
    }

    fun comprobarLuzPantalla() {
        val estadoLuzPantalla = if (luzPantallaEncendida) "encendida" else "apagada"
        println("La luz de la pantalla del teléfono está $estadoLuzPantalla.")
    }
}

class TelefonoPlegable(var estaPlegado: Boolean = true): Telefono() {
    override fun encender() {
        if (!estaPlegado) {
            luzPantallaEncendida = true
        }
    }

    fun plegar() {
        estaPlegado = true
    }

    fun desplegar() {
        estaPlegado = false
    }
}

fun main() {
    val nuevoTelefonoPlegable = TelefonoPlegable()

    nuevoTelefonoPlegable.encender()
    nuevoTelefonoPlegable.comprobarLuzPantalla()
    nuevoTelefonoPlegable.desplegar()
    nuevoTelefonoPlegable.encender()
    nuevoTelefonoPlegable.comprobarLuzPantalla()
}