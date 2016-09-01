package forEachExemple;

@FunctionalInterface
public interface Validador<T> {

	boolean valida(T t);
	
}
