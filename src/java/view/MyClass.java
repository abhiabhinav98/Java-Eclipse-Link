/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UsersJpaController;
import controller.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.States;
import model.Users;

/**
 *
 * @author HP
 */
public class MyClass {
    public void add(){
        Users user = new Users();
        user.setFullname("abc xyz");
        String nameparts[] = user.getFullname().split("\\s+");
        user.setFname(nameparts[0]);
        user.setLname(nameparts[1]);
        user.setUsername("xyz");
        user.setPassword("root");
        user.setState(new States(1));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_demo1PU");
        UsersJpaController controller = new UsersJpaController(emf);
        controller.create(user);
    }
    
    public static void main(String[] args) {
        //new MyClass().add();
        //new MyClass().add();
        //new MyClass().findusersbyfname();
        new MyClass().findAll();
    }
    
    public void delete() throws NonexistentEntityException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_demo1PU");
        UsersJpaController controller = new UsersJpaController(emf);
        controller.destroy(1);
    }
    
    public void findAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_demo1PU");
        UsersJpaController controller = new UsersJpaController(emf);
        List<Users> list = controller.findUsersEntities();
        for(Users user: list){
            System.out.println(user.getFname()+""+user.getLname());
        }
    }

        public void login(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_demo1PU");
        UsersJpaController controller = new UsersJpaController(emf);
        Users user = controller.login2("abhinav123", "root");
        System.out.println(user.getFname()+" "+user.getLname());
        System.out.println(user.getState().getName());
    }

        public void findusersbystate(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_demo1PU");
        UsersJpaController controller = new UsersJpaController(emf);
        List<Users> users = controller.findUsersByState(1);
        for(Users u : users){
            System.out.println(u.getFname()+" "+u.getState().getName());
        }
        
    }
        
        public void findusersbyfname(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_demo1PU");
        UsersJpaController controller = new UsersJpaController(emf);
        List<Users> users = controller.findUsersByFname("Abhi%");
        for(Users u : users){
            System.out.println(u.getFname()+" "+u.getLname());
        }
        
    }
    
}
