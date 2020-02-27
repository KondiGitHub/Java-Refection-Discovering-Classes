package CreatingObjects.factory;

import java.io.IOException;

public class FactoryClient {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        Dbase dbase = Factory.createDbase();
        System.out.println(dbase.getClass().getName());
        dbase.read();
        dbase.write(new Record());

    }
}
