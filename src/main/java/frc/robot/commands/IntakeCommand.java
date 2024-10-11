package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends Command{
    
private final IntakeSubsystem intakeSubsystem;
private final XboxController p2Controller;

    public IntakeCommand(
        IntakeSubsystem intakeSubsystem2, 
        XboxController p2Controller
    ){
         this.intakeSubsystem = intakeSubsystem;
         this.p2Controller = p2Controller;
        
         addRequirements(intakeSubsystem);
    }

    public void IntakeCollect(){
        intakeSubsystem.setIntakeSpeed
        (0.1);
    }

    public void IntakeStop(){
        intakeSubsystem.setIntakeSpeed
        (0);
    }

    @Override
    public void execute(){
    }
    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
      }
}
