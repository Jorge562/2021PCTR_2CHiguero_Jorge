package simulador_juego.solucion;
import java.util.concurrent.TimeUnit;
/**
 * @author Jorge Higuero Peña
 *
 */

//Implementar ActividadAliada
public class ActividadAliada implements Runnable{
		
		//Definir los atributos de la clase
		private int tipoEnemigo;
		private IJuego juego;

		
		//Implementar el constructor de la clase con sus atributos
		public ActividadAliada(int tipoEnemigo, IJuego juego) {
			this.tipoEnemigo = tipoEnemigo;
			this.juego = juego;
		}
		
		//Implementar la actividad aliada (eliminar un enemigo de X tipo)
		public void run() {
			try {
				juego.eliminarEnemigo(tipoEnemigo);
			} catch (InterruptedException e1) {
				//Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				TimeUnit.MILLISECONDS.sleep((long) (Math.random()*5));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
}
