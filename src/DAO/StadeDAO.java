/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Stade;
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

/**
 *
 * @author Rym
 */
public class StadeDAO implements IDao<Stade>{
    


    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    Statement ste;
    public StadeDAO() {
       connection =(DataSource.getInstance()).getConnection();
    }
    
    @Override
    public void add(Stade s) {
        try {
            String req="INSERT INTO `stade`(`libelle_stade`, `adresse_stade`, `ville_stade`, `type_stade`, `capacite_stade`) VALUES (?,?,?,?,?)";
            pst=connection.prepareStatement(req);
            
            pst.setString(1, s.getLibelle_stade());
            pst.setString(2, s.getAdresse_stade());
            pst.setString(3, s.getVille_stade());
            pst.setString(4, s.getType_stade());
            pst.setInt(5, s.getCapacite_stade());
           
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void update(Stade s, int id) {
       
              String req ="UPDATE stade set libelle_stade=?, adresse_stade=?,ville_stade =?,type_stade=?, capacite_stade=? where id_stade=?";
           try {         
            pst = connection.prepareStatement(req);
            pst.setInt(6,id);
            pst.setString(1,s.getLibelle_stade());
            pst.setString(2,s.getAdresse_stade());
            pst.setString(3,s.getVille_stade());
            pst.setString(4,s.getType_stade());
            pst.setInt(5,s.getCapacite_stade());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    @Override
    public void delete(int id) {
        try {
            String req3= "delete from `stade` where `id_stade`="+id;
            pst=connection.prepareStatement(req3);
            pst.executeUpdate(req3);
        } catch (SQLException ex) {
            Logger.getLogger(StadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Stade> displayAll() {
        String req="select * from stade";
        List<Stade> sl=new ArrayList<>();
        
        try {
            pst=connection.prepareStatement(req);
            rs=pst.executeQuery();
            
            while(rs.next()){
                Stade pp;
                pp = new Stade(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getInt(6));
                sl.add(pp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sl;
    }
    
   
    public Stade findById(Stade p) {
        Stade c = new Stade();
        
        return c;
    }


    @Override
    public List<Stade> findByName(String lib) {
        String req="select * from stade where libelle_stade=?";
        List<Stade> lists=new ArrayList<>();
        Stade s=new Stade();
        
        try {
            pst=connection.prepareStatement(req);
            pst.setString(1,lib);
            rs=pst.executeQuery();
            
            while(rs.next()){
               
            s.setId_stade(rs.getInt("id_stade"));
            s.setLibelle_stade(rs.getString("libelle_stade"));
            s.setAdresse_stade(rs.getString("adresse_stade"));
            s.setVille_stade(rs.getString("ville_stade"));
            s.setType_stade(rs.getString("type_stade"));
            s.setCapacite_stade(rs.getInt("capacite_stade"));
           
                
                
                lists.add(s);
            }
            System.out.println("list size "+lists.size());
            return lists;
        } catch (SQLException ex) {
                 System.out.println("erreur de recherche");
            Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        }
    }

    


    public void update_nbr_ticket1(Stade t, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update_nbr_ticket1(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    }
    



