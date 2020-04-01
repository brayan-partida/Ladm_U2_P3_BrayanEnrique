package mx.edu.ittepic.ladm_u2_p3_brayanenrique

import android.widget.TextView

class Persona {
    var puntaje = 0
    var nombre = ""
    var elemento=0
  var turno=0
    var etiqueta: TextView? = null

    fun tirarDados(): Int {
        return (1..6).random()
    }
}