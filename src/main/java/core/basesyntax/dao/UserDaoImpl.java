package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        Storage.users.add(user);
    }

    @Override
    public Set<User> getAllUser() {
        return Storage.users;
    }

    @Override
    public boolean addBetToUser(User user, Bet bet) {
        if (user == null && bet == null) {
            return false;
        }
        user.getBets().add(bet);
        add(user);
        return true;
    }
}
