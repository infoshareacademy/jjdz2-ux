package com.sionach.ux.apiConsumer;


import com.sionach.ux.databaseEntities.Activity;
import com.sionach.ux.databaseEntities.ActivityDAO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * Created by drzalek on 27.02.2017.
 */
@Path("/activity")
public class ActivityApi {

    @EJB
    ActivityDAO activityDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public void addUserToDB(@HeaderParam("name") String name){
        System.out.println("name = " + name);
        activityDAO.save(name, System.currentTimeMillis()/1000);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity> readUserId(){
      return activityDAO.readUserId();
    }

}
