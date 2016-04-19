package org.usfirst.frc.team5086.robot.commands.actions;

import org.usfirst.frc.team5086.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class Forward extends Command {

	public double speed = 0;
	
	
	/**
	 * Auton Code to make the bot go forward.
	 * 
	 * @param speedA The speed you would like the bot to move at. 1=100%, Positive=Forward.
	 * 
	 * @author Josh (I'm not a nerd I swear)
	 */
    public Forward(double speedA) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	speed = speedA;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DriveSystem.forward(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
