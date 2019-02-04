package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Before
    public void before() {
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        TableHandler tableHandler = new TableHandler();
        tableHandler.createTable();

        for(Integer key : tableHandler.table.rowKeySet()){
            System.out.println("Row: " + key);

            for(Map.Entry<String, String> row : tableHandler.table.row(key).entrySet()) {
                System.out.println(row.getKey() + ": " + row.getValue());
            }
        }
    }
}
