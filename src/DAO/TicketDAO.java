/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Rym
 */
import entity.Ticket;
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



public class TicketDAO implements IDao<Ticket>{
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    Statement ste;
    public TicketDAO() {
       connection =(DataSource.getInstance()).getConnection();
    }
    
    public void add(Ticket t) {
        try {
            String req="INSERT INTO `ticket`(`libelle_ticket`,`prix_ticket`, `match_id_match`,`stade_id_stade`,`nbr_ticket_dispo`) VALUES (?,?,?,?,?)";
            pst=connection.prepareStatement(req);
            
            pst.setString(1, t.getLibelle_ticket());
            pst.setFloat(2, t.getPrix_ticket());
            pst.setInt(3, t.getMatch_id_match());
            pst.setInt(4, t.getStade_id_stade());
            pst.setInt(5, t.getNbr_ticket_dispo());

            pst.executeUpdate();
            System.out.println("ajout fait");
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

     public void update(Ticket t, int id) {
        
        String req2 ="UPDATE ticket SET libelle_ticket=?,prix_ticket=?,match_id_match=?,stade_id_stade=?,nbr_ticket_dispo=? WHERE id_ticket=?";
           try {         
            pst = connection.prepareStatement(req2);
        
             pst.setString(1, t.getLibelle_ticket());
            pst.setFloat(2, t.getPrix_ticket());
            pst.setInt(3, t.getMatch_id_match());
            pst.setInt(4, t.getStade_id_stade());
            pst.setInt(5, t.getNbr_ticket_dispo());
           pst.setInt(6,id);
           
            pst.executeUpdate();
            
               System.out.println("update avec succes");
        } catch (SQLException ex) {
              System.out.println("update erreur");
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void delete(int id) {
      try {
            String req3= "delete from `ticket` where `id_ticket`="+id;
            pst=connection.prepareStatement(req3);
            pst.executeUpdate(req3);
            System.out.println("delete with success");
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Ticket> displayAll() {
        String req="select * from ticket";
        List<Ticket> tl=new ArrayList<>();
        
        try {
            pst=connection.prepareStatement(req);
            rs=pst.executeQuery();
            
            while(rs.next()){
                Ticket t;
                t = new Ticket (rs.getInt(1),rs.getString(2), rs.getFloat(3),rs.getInt(4), rs.getInt(5),rs.getInt(6));
                tl.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tl;
    }
    
    
   
    public Ticket findById(Ticket p) {
        Ticket t = new Ticket();
        return t;
    }

   

    @Override
    public List<Ticket> findByName(String lib) {
       
        
        String req="select * from ticket where libelle_ticket=?";
        List<Ticket> listl=new ArrayList<>();
        Ticket t=new Ticket();
        
        try {
            pst=connection.prepareStatement(req);
            pst.setString(1,lib);
            rs=pst.executeQuery();
            
            while(rs.next()){
               
            t.setId_ticket(rs.getInt("id_ticket"));
            t.setLibelle_ticket(rs.getString("libelle_ticket"));
            t.setPrix_ticket(rs.getFloat("prix_ticket"));
            t.setMatch_id_match(rs.getInt("match_id_match"));
            t.setStade_id_stade(rs.getInt("stade_id_stade"));
            t.setNbr_ticket_dispo(rs.getInt("nbr_ticket_dispo"));
           
                
                listl.add(t);
            }
            System.out.println("list voila ça marche");
            return listl;
        } catch (SQLException ex) {
                 System.out.println("erreur de recherche");
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        }
    }
    public void update_nbr_ticket(int id)
            
    {
        String req2 ="UPDATE ticket SET nbr_ticket_dispo=nbr_ticket_dispo-1 WHERE id_ticket="+id;
        try {         
            pst = connection.prepareStatement(req2);
            pst.executeUpdate();
            
               System.out.println("update avec succes");
        } catch (SQLException ex) {
              System.out.println("update erreur");
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public void update_nbr_ticket1(int id)
            
    {
        String req2 ="UPDATE ticket SET nbr_ticket_dispo=nbr_ticket_dispo+1 WHERE id_ticket="+id;
        try {         
            pst = connection.prepareStatement(req2);
            pst.executeUpdate();
            
               System.out.println("update avec succes");
        } catch (SQLException ex) {
              System.out.println("update erreur");
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  
    
}



    

