package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Player;
import com.lambdaschool.starthere.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "playerService")
public class PlayerServiceImpl implements PlayerService{
    @Autowired
    private PlayerRepository playersrepos;

    @Override
    public List<Player> findAll(){
        List<Player> playerList = new ArrayList<>();
        playersrepos.findAll().iterator().forEachRemaining(playerList::add);
        return playerList;
    }


    @Override
    public Player findByPlayerId(long id) throws EntityNotFoundException {
        return playersrepos.findById(id).orElseThrow(()-> new EntityNotFoundException(" " + id));
    }

    @Override
    public Player findByPlayerName(String name){
        Player player = playersrepos.findByName(name);
        if(player == null){
            throw new EntityNotFoundException("Player Not Found" + name);
        }
        return player;
    }

    @Override
    public void delete(long id){
        if(playersrepos.findById(id).isPresent()){
            playersrepos.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("ID" + id);
        }
    }





    @Override
    public Player save(Player player){
        Player newPlayer = new Player();
        newPlayer.setId(player.getId());
        newPlayer.setName(player.getName());
        newPlayer.setTeam(player.getTeam());
        newPlayer.setYears(player.getYears());
        newPlayer.setGames(player.getGames());
        newPlayer.setMinutesplayed(player.getMinutesplayed());
        newPlayer.setPoints(player.getPoints());
        newPlayer.setAssists(player.getAssists());
        newPlayer.setFieldgoalpercentage(player.getFieldgoalpercentage());
        newPlayer.setMinutespergame(player.getMinutespergame());
        newPlayer.setPointspergame(player.getPointspergame());
        newPlayer.setAssistspergame(player.getAssistspergame());
        return playersrepos.save(newPlayer);
    }

    @Override
    public Player update(Player player, long id){
        Player currentPlayer = playersrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (player.getCustname() != null)
        {
            currentPlayer.setCustname(player.getCustname());
        }

        if (player.getCustcity() != null)
        {
            currentPlayer.setCustcity(player.getCustcity());
        }

        if (player.getWorkingarea() != null)
        {
            currentPlayer.setWorkingarea(player.getWorkingarea());
        }

        if (player.getCustcountry() != null)
        {
            currentPlayer.setCustcountry(player.getCustcountry());
        }

        if (player.getGrade() != null)
        {
            currentPlayer.setGrade(player.getGrade());
        }

        if (player.getOpeningamt()!= 0)
        {
            currentPlayer.setOpeningamt(player.getOpeningamt());
        }

        if (player.getReceiveamt() != 0)
        {
            currentPlayer.setReceiveamt(player.getReceiveamt());
        }

        if (player.getPaymentamt() != 0)
        {
            currentPlayer.setPaymentamt(player.getPaymentamt());
        }

        if (player.getOutstandingamt() != 0)
        {
            currentPlayer.setOutstandingamt(player.getOutstandingamt());
        }

        if (player.getPhone() != null)
        {
            currentPlayer.setPhone(player.getPhone());
        }

        if (player.getAgent() !=null)
        {
            currentPlayer.setAgent(player.getAgent());
        }

        // adds new orders
        if (player.getOrders().size() > 0)
        {
            for (Orders o : player.getOrders())
            {
                currentPlayer.getOrders().add(new Orders(o.getOrdamount(), o.getAdvanceamount(), currentPlayer, o.getOrddescription()));
            }
        }

        return custrepos.save(currentPlayer);

    }
}
