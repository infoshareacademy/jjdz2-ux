package com.sionach.ux.apiConsumer;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



/**
 * Created by drzalek on 27.02.2017.
 */
@Stateless
public class ActivityApiConsumer {

    public void sendActivityToDB(String name){
        Client client = ClientBuilder.newClient();
        System.out.println("params = " + name);

        //Form form = new Form().param("userFb", fbId).param("dateOfLogin", String.valueOf(dateOfLogin));
        Response response = client.target("http://report:8080/sionach-ux-report/api/activity")
                .request()
                .header("name", name)
                .post(Entity.entity(name, MediaType.APPLICATION_JSON));
//        response.close();

    }


}