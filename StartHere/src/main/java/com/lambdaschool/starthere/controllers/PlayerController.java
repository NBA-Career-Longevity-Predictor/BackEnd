package com.lambdaschool.starthere.controllers;
import com.lambdaschool.starthere.models.Player;
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

    // taken from https://openlibrary.org/dev/docs/api/books
    // returns a list of books - you can include multiple ISBNs in a single request
    // This API returns a map instead of the standard list
    //
    // localhost:2019/otherapis/openlibrary/0982477562

    @GetMapping(value = "/player/{id}",
            produces = {"application/json"})
    public ResponseEntity<?> listAPlayerByName(HttpServletRequest request,
                                                @PathVariable
                                                        int id)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Player player = new Player();
        player.findPlayersByID(id);


        System.out.println(player);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
//    @Autowired
//    private PlayerService playerService;
//
//
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
////    @ApiOperation(value = "Saves a Player to your saved List", response = void.class)
////    @ApiResponses(value = {
////            @ApiResponse(code = 201, message = "Player was saved successfully"),
////            @ApiResponse(code = 500, message = "Error saving Player")
////})
////    @PostMapping(value = "/player/save",
////            consumes = {"application/json"},
////            produces = {"application/json"})
////    public ResponseEntity<?> addNewPlayer(@Valid
////                                            @RequestBody
////                                                    Player newplayer) throws URISyntaxException
////    {
////        newplayer = playerService.save(newplayer);
////
////        // set the location header for the newly created resource
////        HttpHeaders responseHeaders = new HttpHeaders();
////        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newplayer.findPlayersByID("{id}")).toUri();
////        responseHeaders.setLocation(newCustomerURI);
////
////        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
////    }
}
