/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
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
import utils.DataSource;
import java.sql.Date;

/**
 *
 * @author Rym
 */
public class ReservationDAO implements IDao<Reservation>{
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    Statement ste;
    public ReservationDAO() {
       connection =(DataSource.getInstance()).getConnection();
    }
    
    @Override
    public void add(Reservation r) {
        try {
            String req="INSERT INTO `reservation`(`date_recuperation_ticket`, `ticket_id_ticket`, `bloc`,`seat`) VALUES (?,?,?,?)";
            pst=connection.prepareStatement(req);
            
            pst.setDate(1, (Date) r.getDate_recuperation_ticket());
            pst.setInt(2,r.getTicket_id_ticket());
            pst.setString(3, r.getBlock());
            pst.setString(4, r.getSeat());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void update(Reservation s, int id) {
       String req ="UPDATE reservation set date_recuperation_ticket=?, ticket_id_ticket=?, bloc=?,seat=? where id_reservation=?";
           try {         
            pst = connection.prepareStatement(req);
            pst.setInt(5,s.getId_reservation());
            pst.setDate(1, (Date) s.getDate_recuperation_ticket());
            pst.setInt(2,s.getTicket_id_ticket());
            pst.setString(3,s.getBlock());
            pst.setString(4,s.getSeat());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    @Override
    public void delete(int id) {
        try {
            String req3= "delete from `reservation` where `id_reservation`="+id;
            pst=connection.prepareStatement(req3);
            pst.executeUpdate(req3);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reservation> displayAll() {
        String req="select * from reservation";
        List<Reservation> sl=new ArrayList<>();
        
        try {
            pst=connection.prepareStatement(req);
            rs=pst.executeQuery();
            
            while(rs.next()){
                Reservation pp= new Reservation(rs.getDate(2), rs.getInt(3),rs.getString(4),rs.getString(5));
  
                sl.add(pp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sl;
    }
    
   
    public Reservation findById(Reservation p) {
            return p;
    }

    

    @Override
   public List<Reservation> findByName(String Name) {
       String req="select * from reservation where libelle_reservation=?";
        List<Reservation> listr=new ArrayList<>();
        Reservation r=new Reservation();
        
       try {
            pst=connection.prepareStatement(req);
           // pst.setString(1,lib);
            rs=pst.executeQuery();
            
            while(rs.next()){
               
            r.setId_reservation(rs.getInt("id_reservation"));
            r.setDate_recuperation_ticket(rs.getDate("date_recuperation_ticket"));
            r.setTicket_id_ticket(rs.getInt("ticket_id_ticket"));
            r.setBlock(rs.getString("block"));
            r.setSeat(rs.getString("seat"));
            
                
                
                listr.add(r);
            }
            System.out.println("list size "+listr.size());
            return listr;
        } catch (SQLException ex) {
                 System.out.println("erreur de recherche");
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }}

    public void update_nbr_ticket1(Reservation t, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update_nbr_ticket1(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
    



   

   




