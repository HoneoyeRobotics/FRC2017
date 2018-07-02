package org.usfirst.frc.team3951.kjr2017.robot.subsystems;

import org.usfirst.frc.team3951.kjr2017.robot.Robot;
import org.usfirst.frc.team3951.kjr2017.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BallPickup extends Subsystem {

	
	private Spark ballPickupMotor = new Spark(RobotMap.BALL_PICKUP_MOTOR_ID);

	
	public BallPickup() {
		super("BallPickup");		
	}
	public void PickUpBalls()
	{
		PickUpBalls(0.5);
	}
	public void PickUpBalls(double speed) {
		ballPickupMotor.set(speed);

		SmartDashboard.putNumber("Right Encoder Value", Robot.drivetrain.getRightMotorPosition());
	}
	
	public void stop() {
		ballPickupMotor.stopMotor();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}	
}
