package data;

import model.Player;
import model.Team;

import java.util.ArrayList;
import java.util.List;

public class DemoData {
    public static List<Team> teams = new ArrayList<>();
    public static List<Player> players = new ArrayList<>();

    static{
        Team t1 = new Team(1, "NK Celik","Zenica", 1945);
        Team t2 = new Team(2,"FK Sarajevo","Sarajevo", 1938);

        Player p1 = new Player(101L, "Edin","Dzeko","napadac", 11,t1);
        Player p2 = new Player(102L, "Edin","Tabak","Odbrana", 10,t2);
        Player p3 = new Player(103L, "Samir","Lemes","Vezni", 99,t2);

        t1.getPlayers().add(p1);
        t2.getPlayers().add(p2);
        t1.getPlayers().add(p3);

        teams.add(t1);
        teams.add(t2);

        players.add(p1);
        players.add(p2);
        players.add(p3);
    }
}
