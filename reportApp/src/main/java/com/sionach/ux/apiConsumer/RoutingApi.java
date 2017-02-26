package com.sionach.ux.apiConsumer;


import com.sionach.ux.databaseEntities.Routing;
import com.sionach.ux.databaseEntities.RoutingDAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("/routing")
public class RoutingApi {

    @EJB
    RoutingDAO routingDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public void addLinksToDB(@HeaderParam("url") String url,
                             @HeaderParam("innerLinks") int innerLinks,
                             @HeaderParam("outerLinks") int outerLinks){
        routingDAO.save(url, innerLinks, outerLinks);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Routing> getLinksFromDB(){
        return routingDAO.read();
    }
}
