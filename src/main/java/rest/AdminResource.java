package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entities.User;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.List;

@Path ("admin")
public class AdminResource {

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("users")
    @RolesAllowed("admin")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery ("select u from User u",entities.User.class);
            List<User> users = query.getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public String getFromUser() {
        String thisadmin = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello: " + thisadmin + " this is the admin page\"}";
    }

}
