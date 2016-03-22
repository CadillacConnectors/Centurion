package org.usfirst.frc.team5086.robot.commands;

import org.usfirst.frc.team5086.robot.commands.actions.Forward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Test extends CommandGroup {

    public Test() {
        addSequential(new Forward(-.5), 2);
        addSequential(new Forward(0), 0.1);
    }
}
