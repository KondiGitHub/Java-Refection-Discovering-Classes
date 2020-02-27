package CreatingObjects.factory;

public class OtherDataBase implements Dbase {
    public void write(Record obj) {
        System.out.println("OtherDataBase writing");
    }

    public Record read() {
        System.out.println("OtherDataBase reading");
        return new Record();
    }
}
