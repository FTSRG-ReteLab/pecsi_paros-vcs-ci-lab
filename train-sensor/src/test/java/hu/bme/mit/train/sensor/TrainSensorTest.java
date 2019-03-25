package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Map;

import static org.mockito.Mockito.*;

public class TrainSensorTest {


    TrainUser u;
    TrainController c;
    TrainSensor s;

    @Before
    public void before() {
        u = mock(TrainUser.class);
        c = mock(TrainController.class);
        s = new TrainSensorImpl(c, u);

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

    @Test
    public void HalfOfReferenceSpeed(){

        s.overrideSpeedLimit(c.getReferenceSpeed()/2-1);

        verify(u, times(1)).setAlarmState(true);

    }

    @Test
    public void MoreThanOneAndHalfOfReferenceSpeed(){

        s.overrideSpeedLimit(c.getReferenceSpeed() + c.getReferenceSpeed()/2+1);

        verify(u, times(1)).setAlarmState(true);

    }

}
