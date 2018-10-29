package org.usfirst.frc.team3951.kjr2017.robot.commands;
import org.usfirst.frc.team3951.kjr2017.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PickUpBalls extends  Command {

	public PickUpBalls(){
		this(5);
	}
	public PickUpBalls(double timeout) {
		super("PickUpBalls");
		requires(Robot.ballpickup);
		setInterruptible(true);	
		//if no timeout set, set to 1.
		if(timeout <= 0)
			timeout = 5;
		setTimeout(timeout);		
	}
		
	
	//run arm wheels full speed
	@Override 
	protected void execute() {		
		Robot.ballpickup.PickUpBalls();
	}
	
	//Chew is finished when 
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}


	//at the end, stop the motor.
	@Override
	protected void end() {
		Robot.ballpickup.stop();
	}
	

	//if the command is interrupted(cancelled), stop the motor.
	@Override
	protected void interrupted() {
		Robot.ballshooter.stop();
	}
	
		
}
