package hero;

import java.util.ArrayList;

public class Log implements ILogger {
    private ArrayList log;

    public Log(ArrayList otherLog) {
        log = otherLog;
    }

    @Override
    public void add(String message) {
        log.add(message);
    }

    @Override
    public void display() {
        for(Object message:log){
            System.out.println(message);
        }
        System.out.println();
    }
}
