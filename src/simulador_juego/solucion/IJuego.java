package simulador_juego.solucion;

/*
 * @author Jorge Higuero Peña
 */

public interface IJuego {
	//Definir los métodos de la Interfaz
	public void generarEnemigo(int tipoEnemigo);
	public void eliminarEnemigo(int tipoEnemigo) throws InterruptedException;
}