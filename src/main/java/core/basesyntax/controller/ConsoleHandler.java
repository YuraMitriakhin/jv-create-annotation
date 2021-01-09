package core.basesyntax.controller;

import core.basesyntax.annotation.Inject;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;

    @Inject
    private UserDao userDao;

    public void userHandler() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input name:");
            String name = scanner.nextLine();
            System.out.print("Input email:");
            String email = scanner.nextLine();
            User user = new User(name, email);
            userDao.add(user);
            System.out.println("Input value and risk for " + user.getName() + " bet");
            handler(user);
            System.out.println(user);
            System.out.println("Do you want input new user(y/n)?");
            if (scanner.nextLine().equals("n")) {
                System.out.println(betDao.getAll());
                break;
            }
        }
    }

    private void handler(User user) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                break;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please input correct data!");
            }
            if (!userDao.addBetToUser(user, bet)) {
                System.out.println("You have some mistake. Bet hasn't added!");
            }
            if (bet != null) {
                betDao.add(bet);
            }
        }
    }
}
