package core.basesyntax;

import core.basesyntax.annotation.Injector;
import core.basesyntax.controller.ConsoleHandler;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Input new user");
        handler.userHandler();
    }
}
