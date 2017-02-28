package com.sionach.ux.apiConsumer;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;



/**
 * Created by drzalek on 27.02.2017.
 */
@Stateless
public class ActivityApiConsumer {

    public void sendActivityToDB(String fbId, Long dateOfLogin){
        Client client = ClientBuilder.newClient();
        Form form = new Form().param("userFb", fbId).param("dateOfLogin", String.valueOf(dateOfLogin));
        Response response = client.target("http://localhost:8081/sionach-ux-report/api/activity/").request().post(Entity.form(form));
        response.close();
    }


}