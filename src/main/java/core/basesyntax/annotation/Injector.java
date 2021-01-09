package core.basesyntax.annotation;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exception.DaoAnnotationNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == BetDao.class
                        && checkAnnotationDao(BetDaoImpl.class)) {
                    field.set(instance, new BetDaoImpl());
                } else if (field.getType() == UserDao.class
                        && checkAnnotationDao(UserDaoImpl.class)) {
                    field.set(instance, new UserDaoImpl());
                } else {
                    throw new DaoAnnotationNotFoundException("Annotation @Dao not found!");
                }
            }
        }
        return instance;
    }

    private static boolean checkAnnotationDao(Class clazz) {
        return Arrays.stream(clazz.getDeclaredAnnotations())
                .filter(a -> a.annotationType() == Dao.class)
                .findAny()
                .isPresent();
    }
}
