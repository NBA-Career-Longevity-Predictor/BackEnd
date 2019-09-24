package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Player;
import com.lambdaschool.starthere.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PlayerController
{
    @Autowired
    private PlayerService playerService;

    //List of all players
    @GetMapping(value="/players", produces = {"application/json"})
    public ResponseEntity<?> listAllPlayers()
    {
        List<Player> myPlayer = playerService.findAll();
        return new ResponseEntity<>(myPlayer, HttpStatus.OK);
    }

    //Specific player stats
    @GetMapping(value="/players/{name}", produces ={"application/json"})
    public ResponseEntity<?> findPlayerByName(@PathVariable String name)
    {
        Player myPlayer = playerService.findByPlayerName(name);
        return new ResponseEntity<>(myPlayer, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deletePlayerById(
            @PathVariable
                    long id)
    {
        playerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/player/save",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid
                                            @RequestBody
                                                    Player newplayer) throws URISyntaxException
    {
        newplayer = playerService.save(newplayer);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newplayer.getId()).toUri();
        responseHeaders.setLocation(newCustomerURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}
