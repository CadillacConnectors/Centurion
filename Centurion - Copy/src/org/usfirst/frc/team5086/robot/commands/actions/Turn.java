package org.usfirst.frc.team5086.robot.commands.actions;

import org.usfirst.frc.team5086.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {

	public double turnspeed;
	
	
	/**
	 * Auton Command to make the bot turn
	 * 
	 * @param speed Speed to turn the robot at. Positive turns right.
	 * 
	 * @author Josh (I'm not a nerd I swear)
	 */
    public Turn(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	turnspeed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DriveSystem.hardTurn(turnspeed);
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
