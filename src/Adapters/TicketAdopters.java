
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

/**
 *
 * @author Rym
 */
import DAO.TicketDAO;
import DAO.IDao;
import entity.Ticket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
public class TicketAdopters extends AbstractTableModel{
    String[] headers = {"ID ticket", "Libelle", "Prix","libelle du match","libelle du stade","nbr ticket disponible"};
    List<Ticket> lt = new ArrayList<>();
    IDao TicketDAO;
    
    public TicketAdopters() {
        TicketDAO = new TicketDAO();
        lt= TicketDAO.displayAll();
    }
    public TicketAdopters(List <Ticket> listl,String lib) {
        TicketDAO = new TicketDAO();
        lt = TicketDAO.findByName(lib);
    }

    @Override
    public int getRowCount() {
        return lt.size();
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
                return lt.get(rowIndex).getId_ticket();
            case 1:
                return lt.get(rowIndex).getLibelle_ticket();
            case 2:
                return lt.get(rowIndex).getPrix_ticket();
           
            case 3:
                return lt.get(rowIndex).getMatch_id_match();
            case 4:
                return lt.get(rowIndex).getStade_id_stade();
            
            case 5:
                return lt.get(rowIndex).getNbr_ticket_dispo();
           
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

    

