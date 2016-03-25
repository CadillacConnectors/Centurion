package org.usfirst.frc.team5086.robot.commands;

import org.usfirst.frc.team5086.robot.commands.actions.ChangeTheFattie;
import org.usfirst.frc.team5086.robot.commands.actions.EveryBodiesBucketsGoUp;
import org.usfirst.frc.team5086.robot.commands.actions.Forward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *Lower The Bucket, and run at 90% for 7 seconds
 *
 *@author Josh
 */
public class BucketDownAndRun extends CommandGroup {

    public BucketDownAndRun() {
    	addSequential(new ChangeTheFattie(true),.01);
        addSequential(new Forward(0), 2);
        addSequential(new Forward(.5), .25);
        addSequential(new Forward(0), .21);
        addSequential(new EveryBodiesBucketsGoUp(true), 0.1);
        addSequential(new Forward(0), 2);
    	addSequential(new ChangeTheFattie(false),.01);
        addSequential(new EveryBodiesBucketsGoUp(false), 0.1);
        addSequential(new Forward(.3), 4);
    }
    
}
