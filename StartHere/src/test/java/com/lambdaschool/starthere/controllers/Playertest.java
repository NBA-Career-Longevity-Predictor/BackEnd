
package com.lambdaschool.starthere.controllers;
import com.lambdaschool.starthere.models.Player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class Playertest
{

    @Test
    public void getPlayerByName() throws Exception
    {
        Player player = new Player();
        player.findPlayersByName("James Harden");

        // Arrange
        final String expected = "James Harden";

        // Act
        final String actual = player.getPlayer();

        // Assert
        Assert.assertEquals(actual, expected);
    }
}