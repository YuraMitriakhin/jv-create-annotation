package core.basesyntax.model;

import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Bet> bets;

    public User(int id, String name, List<Bet> bets) {
        this.id = id;
        this.name = name;
        this.bets = bets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", bets=" + bets
                + '}';
    }
}
