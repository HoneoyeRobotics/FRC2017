package org.usfirst.frc.team3951.kjr2017.robot.commands;

import org.usfirst.frc.team3951.kjr2017.robot.OI;
import org.usfirst.frc.team3951.kjr2017.robot.Robot;
import org.usfirst.frc.team3951.kjr2017.robot.RobotMap;
import org.usfirst.frc.team3951.kjr2017.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShootBalls extends  Command {

	public ShootBalls(){
		this(5);
	}
	public ShootBalls(double timeout) {
		super("ShootBalls");
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
		Robot.ballshooter.ShootBalls();
		SmartDashboard.putNumber("Ball Shooter RPM", Robot.ballshooter.getBallShooterVelocity());
		
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
