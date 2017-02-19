package com.sionach.ux.restService;


import com.sionach.ux.colorsReport.Color;
import com.sionach.ux.colorsReport.ColorReport;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/restcolors")
public class RestColors {

    @Inject
    ColorReport colorReport;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getcolors")
    public List<Color> getColors(){
        return colorReport.getColorsWithCounter();
    }

//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("/")
//    public List<Color> saveColors(){
//        return colorReport.getColorsWithCounter();
//    }

}
