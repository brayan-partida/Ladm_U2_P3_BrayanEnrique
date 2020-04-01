package mx.edu.ittepic.ladm_u2_p3_brayanenrique

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var jugador1: HiloControl? = null
    var jugador2: HiloControl? = null
    var jugador3: HiloControl? = null
    var jugador4: HiloControl? = null
    var turnos = 4
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            inicio()
            juego()
            button.setText("Partida En curso")
            button.isEnabled = false
        }
    }

    fun juego() {
        puntaje()
        jugador1!!.start()
        jugador2!!.start()
        jugador3!!.start()
        jugador4!!.start()
        jugador1!!.despausar()
    }

    fun puntaje() {
        puntajeJ1.text = "" + jugador1!!.persona.puntaje
        puntajeJ2.text = "" + jugador2!!.persona.puntaje
        puntajeJ3.text = "" + jugador3!!.persona.puntaje
        puntajeJ4.text = "" + jugador4!!.persona.puntaje

    }

    fun ganador() {
        var ganador = ""
        if (jugador1!!.persona.puntaje > jugador2!!.persona.puntaje) {
            if (jugador1!!.persona.puntaje > jugador3!!.persona.puntaje) {
                if (jugador1!!.persona.puntaje > jugador4!!.persona.puntaje) {
                    ganador = "Jugador 1"
                    button.setText("Juego terminado Gano " + ganador)
                    button.isEnabled = true
                }
            }
        }
        if (jugador2!!.persona.puntaje > jugador1!!.persona.puntaje) {
            if (jugador2!!.persona.puntaje > jugador3!!.persona.puntaje) {
                if (jugador2!!.persona.puntaje > jugador4!!.persona.puntaje) {
                    ganador = "Jugador 2"
                    button.setText("Juego terminado Gano " + ganador)
                    button.isEnabled = true
                }
            }
        }
        if (jugador3!!.persona.puntaje > jugador1!!.persona.puntaje) {
            if (jugador3!!.persona.puntaje > jugador2!!.persona.puntaje) {
                if (jugador3!!.persona.puntaje > jugador4!!.persona.puntaje) {
                    ganador = "Jugador 3"
                    button.setText("Juego terminado Gano " + ganador)
                    button.isEnabled = true
                }
            }
        }
        if (jugador4!!.persona.puntaje > jugador1!!.persona.puntaje) {
            if (jugador4!!.persona.puntaje > jugador2!!.persona.puntaje) {
                if (jugador4!!.persona.puntaje > jugador3!!.persona.puntaje) {
                    ganador = "Jugador 4"
                    button.setText("Juego terminado Gano " + ganador)
                }
            }
        } else {

            Toast.makeText(this, "nadien gano se tiene que repetir el juego", Toast.LENGTH_LONG)
                .show()
            jugador1!!.persona.puntaje = 0
            jugador2!!.persona.puntaje = 0
            jugador3!!.persona.puntaje = 0
            jugador4!!.persona.puntaje = 0
            turnos = 0


        }
        //AlertDialog.Builder(this).setMessage("Ganador es " + ganador).show()
    }

    fun inicio() {
        jugador1 = HiloControl(this)
        jugador2 = HiloControl(this)
        jugador3 = HiloControl(this)
        jugador4 = HiloControl(this)
        jugador1!!.persona.nombre = "J1"
        jugador2!!.persona.nombre = "J2"
        jugador3!!.persona.nombre = "J3"
        jugador4!!.persona.nombre = "J4"
        jugador1!!.persona.etiqueta = estadoJ1
        jugador2!!.persona.etiqueta = estadoJ2
        jugador3!!.persona.etiqueta = estadoJ3
        jugador4!!.persona.etiqueta = estadoJ4
        jugador1!!.persona.etiqueta!!.setText("j1 Listo para jugar")
        jugador2!!.persona.etiqueta!!.setText("J2 Listo Para Jugar")
        jugador3!!.persona.etiqueta!!.setText("J3 listo Para Jugar")
        jugador4!!.persona.etiqueta!!.setText("J4 isto Para Jugar")
    }//todo ---inicio instanciar variables
}

