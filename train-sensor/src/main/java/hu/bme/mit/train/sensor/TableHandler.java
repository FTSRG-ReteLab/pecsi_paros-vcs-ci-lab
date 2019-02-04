package hu.bme.mit.train.sensor;

import com.google.common.collect.*;

class TableHandler {
    public Table<Integer, String, String> table = HashBasedTable.create();

    void createTable(){

        table.put(1, "Current Time", "17:00");
        table.put(1, "Joystick position", "bal");
        table.put(1, "Reference speed", "20");

        table.put(2, "Current Time", "14:20");
        table.put(2, "Joystick position", "jobb");
        table.put(2, "Reference speed", "25");
    }
}