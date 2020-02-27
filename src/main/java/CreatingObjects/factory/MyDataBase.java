package CreatingObjects.factory;

public class MyDataBase implements Dbase {
    public void write(Record obj) {
        System.out.println("MyDataBase writing");
    }

    public Record read() {
        System.out.println("MyDataBase read");
        return new Record();
    }
}
