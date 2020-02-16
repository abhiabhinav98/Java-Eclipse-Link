/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.UsersJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Users;

/**
 * REST Web Service
 *
 * @author HP
 */
@Path("Users")
public class UsersResource {

    @Context
    private UriInfo context;

    public UsersResource() {
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_XML)
    public List<Users> findAllUsers() {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_demo1PU");
        UsersJpaController controller = new UsersJpaController(emf);
        List<Users> list = controller.findUsersEntities();
        return list;
    }
}
