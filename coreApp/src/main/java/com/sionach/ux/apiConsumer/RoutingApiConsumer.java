package com.sionach.ux.apiConsumer;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Stateless
public class RoutingApiConsumer {


    public void sendLinksToDB(String url, int innerLinks, int outerLinks){
        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://localhost:8081/sionach-ux-report/api/routing/");

        Form form = new Form().
            param("url", url).
            param("innerLinks", String.valueOf(innerLinks)).
            param("outerLinks", String.valueOf(outerLinks));

        Response response = client.target("http://localhost:8081/sionach-ux-report/api/routing/")
                .request()
                .post(Entity.form(form));
        response.close();


    }
}
