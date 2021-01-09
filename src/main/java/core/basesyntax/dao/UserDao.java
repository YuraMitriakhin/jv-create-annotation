package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Set;

public interface UserDao {
    void add(User user);

    Set<User> getAllUser();

    boolean addBetToUser(User user, Bet bet);
}
