/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;
import DAO.StadeDAO;
import DAO.IDao;
import entity.Stade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class StadeAdopters extends AbstractTableModel {
    String[] headers = {"ID stade", "Libelle", "Adresse","Ville","type terrain","Capacite"};
    List<Stade> st = new ArrayList<>();
    IDao StadeDAO;
    public StadeAdopters() {
        StadeDAO = new StadeDAO();
        st = StadeDAO.displayAll();
    }
    public StadeAdopters(List <Stade> listl,String lib) {
        StadeDAO = new StadeDAO();
        st = StadeDAO.findByName(lib);
    }

    @Override
    public int getRowCount() {
        return st.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(int i) {
        return headers[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int colmunIndex) {
        switch (colmunIndex) {
            case 0:
                return st.get(rowIndex).getId_stade();
            case 1:
                return st.get(rowIndex).getLibelle_stade();
            case 2:
                return st.get(rowIndex).getAdresse_stade();
            case 3:
                return st.get(rowIndex).getVille_stade();
            case 4:
                return st.get(rowIndex).getType_stade();
            case 5:
                return st.get(rowIndex).getCapacite_stade();
            default:
                return null;
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
