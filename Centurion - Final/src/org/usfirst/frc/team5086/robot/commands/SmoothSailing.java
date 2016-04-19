package org.usfirst.frc.team5086.robot.commands;

import org.usfirst.frc.team5086.robot.commands.actions.ChangeTheFattie;
import org.usfirst.frc.team5086.robot.commands.actions.EveryBodiesBucketsGoUp;
import org.usfirst.frc.team5086.robot.commands.actions.Forward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SmoothSailing extends CommandGroup {

    public SmoothSailing() {
    	//Reset
    	addSequential(new ChangeTheFattie(false), .01);
    	addSequential(new EveryBodiesBucketsGoUp(false), .01);
    	addSequential(new Forward(0), .1);
    	
    	//Actual Stuff
    	addSequential(new ChangeTheFattie(true),.01);
        addSequential(new Forward(0), .5);
        addSequential(new Forward(-.5), .25);
        addSequential(new Forward(0), 1.22);
        addSequential(new Forward(-.5), 6);
        addSequential(new Forward(0), 4);
        addSequential(new ChangeTheFattie(false),.01);
    }
}
