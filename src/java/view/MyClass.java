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
import model.Users;

/**
 *
 * @author HP
 */
public class MyClass {
    public void add(){
        Users user = new Users();
        user.setFname("Abhinav");
        user.setLname("Gupta");
        user.setUsername("abhinav123");
        user.setPassword("root");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_demo1PU");
        UsersJpaController controller = new UsersJpaController(emf);
        controller.create(user);
    }
    
    public static void main(String[] args) {
        //new MyClass().add();
        new MyClass().login();
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
        Users user = controller.login("abhinav123", "root");
        System.out.println(user.getFname()+" "+user.getLname());
    }

    
    
}
