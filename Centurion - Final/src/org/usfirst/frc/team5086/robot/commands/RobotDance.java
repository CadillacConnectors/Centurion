package org.usfirst.frc.team5086.robot.commands;


import org.usfirst.frc.team5086.robot.commands.actions.EveryBodiesBucketsGoUp;
import org.usfirst.frc.team5086.robot.commands.actions.Forward;
import org.usfirst.frc.team5086.robot.commands.actions.Turn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RobotDance extends CommandGroup {

    public RobotDance() {
    	addSequential(new Forward(1), 1);
    	addSequential(new Turn(.25), .5);
    	addParallel(new EveryBodiesBucketsGoUp(true), .01);
    	addSequential(new Turn(-.25), .5);
    	addSequential(new Turn(.25), .5);
    	addSequential(new Turn(-.25), .5);
    	addSequential(new Forward(-1), 1);
    	addParallel(new EveryBodiesBucketsGoUp(false), .01);
    	addSequential(new Turn(1), 1);
    	addSequential(new Turn(-1), 1);
    	addParallel(new EveryBodiesBucketsGoUp(true), .01);
    	addSequential(new Turn(1), 1);
    	addSequential(new Turn(-1), 1);
    	addParallel(new EveryBodiesBucketsGoUp(false), .01);
    }
}
