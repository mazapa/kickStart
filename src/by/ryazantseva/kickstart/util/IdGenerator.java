package by.ryazantseva.kickstart.util;

public class IdGenerator {
    private static long id = 0;
    public static Long generateId(){
        return id++;
    }
}
