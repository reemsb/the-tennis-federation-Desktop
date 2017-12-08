package DAO;

import entity.Club;
import java.util.List;



public interface IDao<T> {
    void add(T t);
    void update(T t,int id);
    void delete (int id);
    List<T> displayAll();
    List<T> findByName(String libelle);

    public void update_nbr_ticket1(int id);
    
}
