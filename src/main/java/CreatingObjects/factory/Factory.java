package CreatingObjects.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Factory {
    public static Dbase createDbase() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("src/main/resources/DBase.properties");
        properties.load(inputStream);
        String name = properties.getProperty("Dbase");
        Dbase dbase = createObject(name);
        inputStream.close();
        return dbase;

    }

    static <T> T createObject(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aclass = Class.forName(name);

      return (T) aclass.newInstance();
    }

}
