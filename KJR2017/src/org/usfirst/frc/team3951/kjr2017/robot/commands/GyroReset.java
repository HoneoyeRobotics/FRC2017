package org.usfirst.frc.team3951.kjr2017.robot.commands;

import org.usfirst.frc.team3951.kjr2017.robot.OI;
import org.usfirst.frc.team3951.kjr2017.robot.Robot;
import org.usfirst.frc.team3951.kjr2017.robot.RobotMap;
import org.usfirst.frc.team3951.kjr2017.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class GyroReset extends  Command {

	public GyroReset() {
		super("GyroReset");
		requires(Robot.drivetrain);
		setInterruptible(true);
		Robot.drivetrain.gyroReset();
	}
	
	@Override 
	protected void execute() {			
		Robot.drivetrain.gyroReset();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	//at the end, stop the motor.
	@Override
	protected void end() {
		
	}
	

	//if the command is interrupted(cancelled), stop the motor.
	@Override
	protected void interrupted() {
		
	}
		
			

}
