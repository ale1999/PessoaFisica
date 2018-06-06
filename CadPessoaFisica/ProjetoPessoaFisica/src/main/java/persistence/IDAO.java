package persistence;

import java.util.List;

public interface IDAO<T> {

	void persistir(T o) throws Exception;
	List<T> Listar() throws Exception;
}
