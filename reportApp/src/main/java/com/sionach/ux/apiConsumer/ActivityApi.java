package com.sionach.ux.apiConsumer;


import com.sionach.ux.databaseEntities.ActivityDAO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Date;
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
    public void addUserToDB(@HeaderParam("userFb") String userFb,
                            @HeaderParam("dateOfLogin") Long dateOfLogin){
        System.out.println(userFb);
        activityDAO.save(userFb, dateOfLogin);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Long> readUserId(){
      return activityDAO.readUserId();
    }

}
