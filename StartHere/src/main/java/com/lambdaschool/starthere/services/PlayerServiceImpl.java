//package com.lambdaschool.starthere.services;
//
//import com.lambdaschool.starthere.models.Player;
//import com.lambdaschool.starthere.repository.PlayerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Transactional
//@Service(value = "playerService")
//public class PlayerServiceImpl implements PlayerService{
//    @Autowired
//    private PlayerRepository playersrepos;
//
//    @Override
//    public List<Player> findAll(){
//        List<Player> playerList = new ArrayList<>();
//        playersrepos.findAll().iterator().forEachRemaining(playerList::add);
//        return playerList;
//    }
//
//
//    @Transactional
//    @Override
//    public Player findByPlayerName(String name){
//        Player player = playersrepos.findByPlayer(name);
//        if(player == null){
//            throw new EntityNotFoundException("Player Not Found" + name);
//        }
//        return player;
//    }
//
//    @Override
//    public void delete(long id){
//        if(playersrepos.findById(id).isPresent()){
//            playersrepos.deleteById(id);
//        }
//        else{
//            throw new EntityNotFoundException("ID" + id);
//        }
//    }
//
//
//
//
//
//    @Override
//    public Player save(Player player){
//        Player newPlayer = new Player();
//        return playersrepos.save(newPlayer);
//    }



//    @Override
//    public Player update(Player player, long id){
//        Player currentPlayer = playersrepos.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
//
//        if (player.getName() != null)
//        {
//            currentPlayer.setName(player.getName());
//        }
//
//        if (player.getTeam() != null)
//        {
//            currentPlayer.setTeam(player.getTeam());
//        }
//
//        if (player.getId() >= 0)
//        {
//            currentPlayer.setId(player.getId());
//        }
//
//        if (player.getYears() != 0)
//        {
//            currentPlayer.setYears(player.getYears());
//        }
//
//        if (player.getGames() >= 0)
//        {
//            currentPlayer.setGames(player.getGames());
//        }
//
//        if (player.getMinutesplayed()!= 0)
//        {
//            currentPlayer.setMinutesplayed(player.getMinutesplayed());
//        }
//
//        if (player.getPoints() != 0)
//        {
//            currentPlayer.setPoints(player.getPoints());
//        }
//
//        if (player.getAssists() != 0)
//        {
//            currentPlayer.setAssists(player.getAssists());
//        }
//
//
//        if (player.getFieldgoalpercentage() != 0)
//        {
//            currentPlayer.setFieldgoalpercentage(player.getFieldgoalpercentage());
//        }
//
//        if (player.getMinutespergame() != 0)
//        {
//            currentPlayer.setMinutespergame(player.getMinutespergame());
//        }
//
//        if (player.getPointspergame() !=0)
//        {
//            currentPlayer.setPointspergame(player.getPointspergame());
//        }
//
//        if (player.getAssistspergame() !=0)
//        {
//            currentPlayer.setAssistspergame(player.getAssistspergame());
//        }
//
//
//
//        return playersrepos.save(currentPlayer);
//
//    }
//}
