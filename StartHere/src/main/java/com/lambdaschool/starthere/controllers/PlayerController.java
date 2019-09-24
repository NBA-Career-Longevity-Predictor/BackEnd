//package com.lambdaschool.starthere.controllers;
//
//import com.lambdaschool.starthere.models.ErrorDetail;
//import com.lambdaschool.starthere.models.Player;
//import com.lambdaschool.starthere.services.PlayerService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import javax.validation.Valid;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.List;
//
//@RestController
//public class PlayerController
//{
//    @Autowired
//    private PlayerService playerService;
//
//    //List of all players
//    @ApiOperation(value = "return all players with stats", response = Player.class, responseContainer = "List")
//    @GetMapping(value="/players", produces = {"application/json"})
//    public ResponseEntity<?> listAllPlayers()
//    {
//        List<Player> myPlayer = playerService.findAll();
//        return new ResponseEntity<>(myPlayer, HttpStatus.OK);
//    }
//
//    //Specific player stats
//    @ApiOperation(value = "Find specific players stats by name", response = Player.class, responseContainer = "List")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Player Found", response = Player.class),
//            @ApiResponse(code = 404, message = "Player not found", response = ErrorDetail.class)
//    })
//    @GetMapping(value="/players/{name}", produces ={"application/json"})
//    public ResponseEntity<?> findPlayerByName(@PathVariable String name)
//    {
//        Player myPlayer = playerService.findByPlayerName(name);
//        return new ResponseEntity<>(myPlayer, HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/delete/{id}")
//    public ResponseEntity<?> deletePlayerById(
//            @PathVariable
//                    long id)
//    {
//        playerService.delete(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Saves a Player to your saved List", response = void.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Player was saved successfully"),
//            @ApiResponse(code = 500, message = "Error saving Player")
//})
//    @PostMapping(value = "/player/save",
//            consumes = {"application/json"},
//            produces = {"application/json"})
//    public ResponseEntity<?> addNewPlayer(@Valid
//                                            @RequestBody
//                                                    Player newplayer) throws URISyntaxException
//    {
//        newplayer = playerService.save(newplayer);
//
//        // set the location header for the newly created resource
//        HttpHeaders responseHeaders = new HttpHeaders();
//        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newplayer.getId()).toUri();
//        responseHeaders.setLocation(newCustomerURI);
//
//        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
//    }
//}
