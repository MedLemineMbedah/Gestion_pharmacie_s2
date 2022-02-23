package dao;

import java.sql.SQLException;
import java.util.List;

public interface Igenerate <T>{
	
//	public void ajouter(T t);
//
//	public T chercherParId(T t);
//	
//	public List<T> lister();
//	
//	public void modifier(T t);
//	
//	public void supprimer(Integer id);
//

	void insertT(T t) throws SQLException;

	T selectT(int TId);

	List<T> selectAllTs();

	boolean deleteT(int id) throws SQLException;

	void updateT(T t) throws SQLException;
}
