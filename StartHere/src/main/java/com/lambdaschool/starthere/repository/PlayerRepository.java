//package com.lambdaschool.starthere.repository;
//
//import com.lambdaschool.starthere.models.Player;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.transaction.annotation.Transactional;
//
//public interface PlayerRepository extends CrudRepository<Player, Long> {
//    @Transactional
//    @Modifying
//    @Query(value = "SELECT * "
//            + "FROM players_nba "
//            + "WHERE player= ?",
//            nativeQuery = true)
//    Player findByPlayer(String name);
//
//}
