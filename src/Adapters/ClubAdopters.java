/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import DAO.ClubDAO;
import DAO.IDao;
import entity.Club;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rym
 */
public class ClubAdopters extends AbstractTableModel{


    String[] headers = {"Id club","Liblle", "Adresse","Ville","numero telephone","fax","nbr terrain","budget"};
    List<Club> cs = new ArrayList<>();
    
    IDao ClubDAO;
    public ClubAdopters() {
        ClubDAO = new ClubDAO();
        cs = ClubDAO.displayAll();
    }
    public ClubAdopters(List <Club> listc,String lib) {
        ClubDAO = new ClubDAO();
        cs = ClubDAO.findByName(lib);
    }
    

    @Override
    public int getRowCount() {
        return cs.size();
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
                return cs.get(rowIndex).getId_club();
            case 1:
                return cs.get(rowIndex).getLibelle_club();
            case 2:
                return cs.get(rowIndex).getAdresse_club();
            case 3:
                return cs.get(rowIndex).getVille_club();
            case 4:
                return cs.get(rowIndex).getNumero_telephone();
            case 5:
                return cs.get(rowIndex).getNumero_fax();
            case 6:
                return cs.get(rowIndex).getNbr_terrain();
            case 7:
                return cs.get(rowIndex).getBudget_club();   
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
