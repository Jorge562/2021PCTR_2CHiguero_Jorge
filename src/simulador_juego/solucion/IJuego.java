package simulador_juego.solucion;

/*
 * @author Jorge Higuero Pe�a
 */

public interface IJuego {
	//Definir los m�todos de la Interfaz
	public void generarEnemigo(int tipoEnemigo);
	public void eliminarEnemigo(int tipoEnemigo) throws InterruptedException;
}