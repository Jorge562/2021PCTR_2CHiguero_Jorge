package simulador_juego.solucion;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Hashtable;

/**
 *
 * @author Jorge Higuero Peña
 */

public class Juego implements IJuego {

	private int contadorEnemigosTotales=0;
	private Map<Integer,Integer> contadoresEnemigosTipo; //enemigos actuales de cada tipo
	private Map<Integer,Integer> contadoresEliminadosTipo;//enemigos eliminados de cada tipo
	private int MAXENEMIGOS;
	private final int MINENEMIGOS=0;
	private int tiposEnemigos;
	

	
	public Juego(int maxEnemigos, int tiposenemigos) {
		this.tiposEnemigos=tiposenemigos;
		this.MAXENEMIGOS=maxEnemigos;
		contadoresEnemigosTipo = new HashMap<>();
		contadoresEliminadosTipo = new HashMap<>();
	};
	
	/*
	 * Implementar la generación de enemigos (con sus condiciones)
	 * La línea en la que se define el método es una plantilla orientativa y puede ser modificada.
	 */
	
	@Override
	public synchronized void generarEnemigo(int tipoEnemigo) {
		for(Integer enemigo: contadoresEnemigosTipo.keySet()) {
			assert(enemigo <= enemigo); // precondiciÃ³n
		}
		if(!contadoresEnemigosTipo.containsKey(tipoEnemigo)) {
			for(int i=0;i<tiposEnemigos;i++) {
				contadoresEnemigosTipo.put(i, 0); //tenemos 0 enemigos de cada tipo al principio
				contadoresEliminadosTipo.put(i,0);
			}
		}
		contadoresEnemigosTipo.put(tipoEnemigo, contadoresEnemigosTipo.get(tipoEnemigo) + 1); //inrementamos los enemigos de ese tipo
		contadorEnemigosTotales++;
		
		assert(contadorEnemigosTotales >= MINENEMIGOS&& contadorEnemigosTotales <= MAXENEMIGOS); 
		
		ImprimirInfo(tipoEnemigo,"generar");
		checkInvariante();
	}
	
	/*
	 * Implementar la eliminación de enemigos (con sus condiciones)
	 * La línea en la que se define el método es una plantilla orientativa y puede ser modificada.
	 */
	
	@Override
	public synchronized void eliminarEnemigo(int tipoEnemigo) throws InterruptedException {
		if (!contadoresEliminadosTipo.containsKey(tipoEnemigo)) {
			wait();
		}

		contadoresEnemigosTipo.put(tipoEnemigo, contadoresEnemigosTipo.get(tipoEnemigo) - 1); //decrementamos los enemigos de ese tipo
		contadoresEliminadosTipo.put(tipoEnemigo, contadoresEliminadosTipo.get(tipoEnemigo) + 1); //incrementamos enemigos eliminados de ese tipo
		contadorEnemigosTotales--;

		ImprimirInfo(tipoEnemigo,"eliminar");
		checkInvariante();
		
	}

	/*
	 * Implementar el método para mostrar el estado del nivel en cada generación o eliminación de enemigos.
	 */	
	private void ImprimirInfo(int tipoEnemigo, String movimiento) {
		if(movimiento=="generar") {
			System.out.println("Generado enemigo tipo " + tipoEnemigo);
		}else {
			System.out.println("Eliminando enemigo tipo " + tipoEnemigo);
		}
		
		System.out.println("--> Enemigos totales: " + contadorEnemigosTotales);
		for (int i = tiposEnemigos; i > 0; i--) {
			System.out.print("----> Enemigos tipo " + (i - 1) + ":" + contadoresEnemigosTipo.get(i - 1));
			System.out.print(" ------ ");
			System.out.println("[Eliminados:" + contadoresEliminadosTipo.get(i - 1) + "]");
		}
		System.out.println();

	};

	/*
	 * Es posible que debamos implementar métodos secundarios necesarios en los métodos anteriores..
	 */
	protected void checkInvariante() {
		int enemigosVivos = 0;
		for (Integer enemigo:contadoresEnemigosTipo.keySet()) {
			enemigosVivos += enemigo;
		}
		assert(contadorEnemigosTotales == enemigosVivos); //invariante -> enemigos vivos igual a enemigos totales
		
	}
}
