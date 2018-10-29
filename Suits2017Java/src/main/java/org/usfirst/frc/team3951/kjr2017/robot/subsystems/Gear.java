package org.usfirst.frc.team3951.kjr2017.robot.subsystems;

import org.usfirst.frc.team3951.kjr2017.robot.Robot;
import org.usfirst.frc.team3951.kjr2017.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Gear extends Subsystem {

	
	private Spark GearMotor = new Spark(RobotMap.GEAR_MOTOR_ID);
	
	
	public Gear() {
		super("Gear");		
	}
	public void OpenGear()
	{
		//PickUpBalls(0.5);
	}
	
	public void CloseGear()
	{
		
	}
	
	
	public void stop() {
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}	
}
