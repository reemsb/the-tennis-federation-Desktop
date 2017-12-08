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
import entity.Club;
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



public class ClubDAO implements IDao<Club>{

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    Statement ste;
    public ClubDAO() {
       connection =(DataSource.getInstance()).getConnection();
    }
    
    @Override
    public void add(Club c) {
        try {
            String req="INSERT INTO `club`(`libelle_club`, `adresse_club`, `ville_club`, `numero_telephone`, `numero_fax`, `nbr_terrain`, `budget_club`) VALUES (?,?,?,?,?,?,?)";
            pst=connection.prepareStatement(req);
            
            pst.setString(1, c.getLibelle_club());
            pst.setString(2, c.getAdresse_club());
            pst.setString(3, c.getVille_club());
            pst.setString(4, c.getNumero_telephone());
            pst.setString(5, c.getNumero_fax());
            pst.setInt(6, c.getNbr_terrain());
            pst.setFloat(7,c.getBudget_club());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void update(Club c, int id) {
        
        String req2 ="UPDATE club SET libelle_club=?,adresse_club=?,ville_club=?,numero_telephone=?,numero_fax=?,nbr_terrain=?,budget_club=? WHERE id_club=?";
           try {         
            pst = connection.prepareStatement(req2);
        
            pst.setString(1,c.getLibelle_club());
            pst.setString(2,c.getAdresse_club());
            pst.setString(3,c.getVille_club());
            pst.setString(4,c.getNumero_telephone());
            pst.setString(5 ,c.getNumero_fax());
            pst.setInt(6,c.getNbr_terrain());
            pst.setFloat(7,c.getBudget_club());
            pst.setInt(8,id);
           
            pst.executeUpdate();
            
               System.out.println("update avec succes");
        } catch (SQLException ex) {
              System.out.println("update erreur");
            Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void delete(int id) {
      try {
            String req3= "delete from `club` where `id_club`="+id;
            pst=connection.prepareStatement(req3);
            pst.executeUpdate(req3);
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Club> displayAll() {
        String req="select * from club";
        List<Club> cl=new ArrayList<>();
        
        try {
            pst=connection.prepareStatement(req);
            rs=pst.executeQuery();
            
            while(rs.next()){
                Club p;
                p = new Club(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6),rs.getInt(7),rs.getFloat(8));
                cl.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cl;
    }
    
   
    @Override
    public List<Club> findByName(String lib) {
       
        
        String req="select * from club where libelle_club=?";
        List<Club> listc=new ArrayList<>();
        Club c=new Club();
        
        try {
            pst=connection.prepareStatement(req);
            pst.setString(1,lib);
            rs=pst.executeQuery();
            
            while(rs.next()){
               
            c.setId_club(rs.getInt("id_club"));
            c.setLibelle_club(rs.getString("libelle_club"));
            c.setAdresse_club(rs.getString("adresse_club"));
            c.setVille_club(rs.getString("ville_club"));
            c.setNumero_telephone(rs.getString("numero_telephone"));
           c.setNumero_fax(rs.getString("numero_fax"));
           c.setNbr_terrain(rs.getInt("nbr_terrain"));
           c.setBudget_club(rs.getFloat("budget_club")); 
                
                
                listc.add(c);
            }
            System.out.println("list size "+listc.size());
            return listc;
        } catch (SQLException ex) {
                 System.out.println("erreur de recherche");
            Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        }
    }

    public List<Club> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    public void update_nbr_ticket1(Club t, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update_nbr_ticket1(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
