/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftt;

import DAO.IDao;
import entity.*;
import java.sql.Date;
import DAO.*;
import interfaces.*;
/**
 *
 * @author Rym
 */
public class FTT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        entity.Club p=new entity.Club("rrr","rrr","rrr","rrr","rrr",1,5) ;
        
        IDao pdao=new ClubDAO();
       // pdao.add(p);
       // pdao.delete(4);
       
        //test add /delete/update club
                /*entity.Stade p1=new entity.Stade("rrr","rrr","rrr","rrr",1) ;
               IDao p1dao=new StadeDAO();
               entity.Stade s1= new entity.Stade("ras","tunis","tunisie","gggg",3);*/
       // p1dao.add(p1);
       // p1dao.add(s1);
       // p1dao.delete(2);
      // p1dao.update(s1,5);
      //update de stade test
       // entity.Club cc= new entity.Club("tn World","marsa","tunis","5598741254","7845951",3,50000) ;
              // pdao.update(cc,16);
       
       //showmyinterface
      //Istade add = new Istade();
      //add.setVisible(true);
      
      Igestion g = new Igestion();
      g.setVisible(true);
     
       
               

       
        

    }
    
}
