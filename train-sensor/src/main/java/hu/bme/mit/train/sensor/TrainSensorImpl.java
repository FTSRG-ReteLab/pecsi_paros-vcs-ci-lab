package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 7;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);

		if(controller.getSpeedLimit() < 0 || speedLimit > 500 ||
				speedLimit < controller.getReferenceSpeed()/2 ||
				speedLimit > controller.getReferenceSpeed()+(controller.getReferenceSpeed()/2)){
			user.setAlarmState(true);
		} else {
			user.setAlarmState(false);
		}
	}

}
