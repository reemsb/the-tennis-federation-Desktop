/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;
import DAO.IDao;
import DAO.ReservationDAO;
import entity.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import utils.DataSource;
/**
 *
 * @author Rym
 */
public class ReservationAdopters  extends AbstractTableModel{
    String[] headers = {"Id reservation","date recuperation", "libelle ticket","le block","la chaise"};
    List<Reservation> rs = new ArrayList<>();
    
    IDao ReservationDAO;
    public ReservationAdopters() {
        ReservationDAO = new ReservationDAO();
        rs = ReservationDAO.displayAll();
    }
    public ReservationAdopters(List <Reservation> listr,String lib) {
        ReservationDAO = new ReservationDAO();
        rs = ReservationDAO.findByName(lib);
    }
    

    public int getRowCount() {
        return rs.size();
    }

    public int getColumnCount() {
        return headers.length;
    }

    public String getColumnName(int i) {
        return headers[i];
    }

    public Object getValueAt(int rowIndex, int colmunIndex) {
        switch (colmunIndex) {
            
            
            case 0:
                return rs.get(rowIndex).getDate_recuperation_ticket();
            case 1:
                return rs.get(rowIndex).getTicket_id_ticket();
            case 2:
                return rs.get(rowIndex).getBlock();
            case 3:
                return rs.get(rowIndex).getSeat();
            
            default:
                return null;
        }
    }

}
