package model;

import java.util.ArrayList;
import java.util.List;


public class Team {

    private int id;
    private String nazivTima;
    private String grad;
    private int godinaOsnivanja;

    private List<Team> teams = new ArrayList<>();
    private List<Player> players;

    public Team(int id, String nazivTima, String grad, int godinaOsnivanja) {
        this.id = id;
        this.nazivTima = nazivTima;
        this.grad = grad;
        this.godinaOsnivanja = godinaOsnivanja;


    }

    public int getId() {return id;
    }

    public void setId(int id) {this.id = id;
    }

    public String getNazivTima() {return nazivTima;
    }

    public void setNazivTima(String nazivTima) {
        this.nazivTima = nazivTima;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getGodinaOsnivanja() {return getGodinaOsnivanja();
    }

    public List<Player> getPlayers() { return getPlayers();}
    public void setPlayers(List<Player> players) { this.players = players;}

}