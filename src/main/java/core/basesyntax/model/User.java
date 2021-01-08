package core.basesyntax.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private List<Bet> bets = new ArrayList<>();

    public User(String name, String email) {
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", email='" + email + '\''
                + ", bets=" + bets
                + '}';
    }
}
