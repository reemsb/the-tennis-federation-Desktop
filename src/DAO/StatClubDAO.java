/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
/**
 *
 * @author Rym
 */
public class StatClubDAO implements IDAOstatclub{
    private   Connection connection;

   public StatClubDAO () {
      //  connection= DataSource.getInstance();
       // Connection = DataSource.getConnection();
       connection =(DataSource.getInstance()).getConnection();

    }

    @Override
    public Integer countClubParNordDuPays() {
        int i=0;
        try {
        
       
        String req ="select count(*) from club where ville_club='tunis' OR ville_club='nabeul' OR ville_club='bizert'";
 Statement st;
        
            st = connection.createStatement();
        

      ResultSet rs=st.executeQuery(req);
 while(rs.next())
 { 
  i=rs.getInt(1);
 }
        }
 catch (SQLException ex) {
            Logger.getLogger(StatClubDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
return i;
     }
 
   
    @Override
    public Integer countClubParCentreDuPays() {
        int i=0;
        try {
        
       
        String req ="select count(*) from club where ville_club='kairouan' OR ville_club='sousse'";
 Statement st;
        
            st = connection.createStatement();
        

      ResultSet rs=st.executeQuery(req);
 while(rs.next())
 { 
  i=rs.getInt(1);
 }
        }
 catch (SQLException ex) {
            Logger.getLogger(StatClubDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
return i;
    }

    @Override
    public Integer countClubParSudDuPays() {
        int i=0;
        try {
        
       
        String req ="select count(*) from club where ville_club='tozeur' OR ville_club='gasrine'";
 Statement st;
        
            st = connection.createStatement();
        

      ResultSet rs=st.executeQuery(req);
 while(rs.next())
 { 
  i=rs.getInt(1);
 }
        }
 catch (SQLException ex) {
            Logger.getLogger(StatClubDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
return i;
    }
    
    }
    

