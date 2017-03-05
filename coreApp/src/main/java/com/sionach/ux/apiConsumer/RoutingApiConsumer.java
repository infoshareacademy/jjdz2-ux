package com.sionach.ux.apiConsumer;

import javax.ejb.Stateless;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Stateless
public class RoutingApiConsumer {


    public void sendLinksToDB(String url, int innerLinks, int outerLinks){
        Client client = ClientBuilder.newClient();

        Response response = client.target("http://report:8080/sionach-ux-report/api/routing/")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("url", url)
                .header("innerLinks", innerLinks)
                .header("outerLinks", outerLinks)
                .build("post").invoke();
    }
}
