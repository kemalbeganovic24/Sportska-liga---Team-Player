package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Long id;
    private String ime;
    private String prezime;
    private String pozicija;
    private int brojDresa;
    private String nazivTima;
    private Team team;
    
    
    private List<Team> teams = new ArrayList<>();
    
    public Player(Long id, String ime, String prezime, String pozicija, int brojDresa, Team team) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.pozicija = pozicija;
        this.brojDresa = brojDresa;
        this.nazivTima = nazivTima;
        this.team= team;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(int lives) {
        this.pozicija = pozicija;
    }

    public int getBrojDresa() {
        return brojDresa;
    }

    public void setBrojDresa(int brojDresa) {
        this.brojDresa = brojDresa;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public String getNazivTima() {
        return nazivTima;
    }

    public void setNazivTima(String nazivTima) {
        this.nazivTima = nazivTima;
    }
}
