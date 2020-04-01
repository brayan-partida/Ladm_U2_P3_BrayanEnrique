package mx.edu.ittepic.ladm_u2_p3_brayanenrique

import kotlinx.android.synthetic.main.activity_main.*

class HiloControl (p:MainActivity) : Thread(){
    private var iniciado = false
    private var puntero = p
    private var pausa = true
    var persona = Persona()

    private var dado1=0
    private var dado2=0



    override fun run() {
        super.run()
        iniciado = true
        while(iniciado){
            sleep(1200)
            if(!pausa){
                dado1=persona.tirarDados()
                dado2=persona.tirarDados()
                puntero.runOnUiThread {
                    persona.etiqueta!!.setText (persona.nombre+ "activo")

                }
                sleep(1000)
                persona.puntaje+=dado1
                persona.puntaje+=dado2
                puntero.runOnUiThread {
                    puntero.puntaje()
                    persona.etiqueta!!.setText( persona.nombre+ "desactivado")
                }
                pausar()
                when(persona.nombre){
                    "J1"->{
                        puntero.jugador2!!.despausar()
                    }
                    "J2"->{
                        puntero.jugador3!!.despausar()
                    }
                    "J3"->{
                        puntero.jugador4!!.despausar()
                    }
                    "J4"->{
                        puntero.turnos--
                        if(puntero.turnos!=0){
                            puntero.jugador1!!.despausar()
                        }
                        else{
                            puntero.runOnUiThread { puntero.ganador() }
                        }

                    }
                }
            }
        }
    }

    fun estaIniciado(): Boolean {
        return iniciado
    }

    fun pausar() {
        pausa = true
    }

    fun despausar() {
        pausa = false
    }

    fun detener() {
        iniciado = false
    }
}