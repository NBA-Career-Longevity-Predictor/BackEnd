package com.lambdaschool.starthere.controllers;
import com.lambdaschool.starthere.models.Player;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import javax.servlet.http.HttpServletRequest;


@RestController
public class PlayerController
{
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);
    private RestTemplate restTemplate = new RestTemplate();

   

    @ApiOperation(value = "Return a player", response = Player.class, responseContainer = "String")
    @GetMapping(value = "/player/{name}",
            produces = {"application/json"})
    public ResponseEntity<?> listAPlayerByName(HttpServletRequest request,
                                                @PathVariable
                                                        String name)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Player player = new Player();
        player.findPlayersByName(name);


        System.out.println(player);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

}
