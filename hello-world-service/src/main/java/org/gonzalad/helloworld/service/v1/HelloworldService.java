package org.gonzalad.helloworld.service.v1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/v1")
public class HelloworldService {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Response<String> helloworld() {
        //return "{\"data\": \"Hello World !\"}";
        return new Response<String>("Hello world !!!");
    }
}
