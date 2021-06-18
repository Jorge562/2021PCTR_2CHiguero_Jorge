package simulador_juego.solucion;

import java.util.concurrent.TimeUnit;
/*
 * @author Jorge Higuero Peña
 */

//Implementar ActividadEnemiga
public class ActividadEnemiga implements Runnable{
		
		//Definir los atributos de la clase
		private int tipoEnemigo;
		private IJuego juego;  
		
		//Implementar el constructor de la clase con sus atributos
		public ActividadEnemiga(int tipoEnemigo,IJuego juego) {
			this.tipoEnemigo=tipoEnemigo;
			this.juego=juego;
		}
		
		//Implementar la actividad enemiga (generar un enemigo de X tipo y esperar X tiempo)
		public void run() {
			juego.generarEnemigo(tipoEnemigo);
			try {
				TimeUnit.MILLISECONDS.sleep((long) (Math.random()*5));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
}
