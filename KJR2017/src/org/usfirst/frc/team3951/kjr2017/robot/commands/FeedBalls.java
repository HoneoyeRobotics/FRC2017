package org.usfirst.frc.team3951.kjr2017.robot.commands;

import org.usfirst.frc.team3951.kjr2017.robot.OI;
import org.usfirst.frc.team3951.kjr2017.robot.Robot;
import org.usfirst.frc.team3951.kjr2017.robot.RobotMap;
import org.usfirst.frc.team3951.kjr2017.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class FeedBalls extends  Command {

	public FeedBalls(){
		this(5);
	}
	public FeedBalls(double timeout) {
		super("FeedBalls");
		requires(Robot.ballshooter);
		setInterruptible(true);	
		//if no timeout set, set to 1.
		if(timeout <= 0)
			timeout = 5;
		setTimeout(timeout);		
	}
		
	
	//run arm wheels full speed
	@Override 
	protected void execute() {		
		Robot.ballshooter.FeedBalls();
	}
	
	//Chew is finished when 
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}


	//at the end, stop the motor.
	@Override
	protected void end() {
		Robot.ballshooter.stop();
	}
	

	//if the command is interrupted(cancelled), stop the motor.
	@Override
	protected void interrupted() {
		Robot.ballshooter.stop();
	}
	
		
}
