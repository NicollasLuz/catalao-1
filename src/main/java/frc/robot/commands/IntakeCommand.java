package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends Command{
    
IntakeSubsystem intakeSubsystem;

    public IntakeCommand(
        IntakeSubsystem intakeSubsystem){
    addRequirements(intakeSubsystem);
    }

    public IntakeCommand(IntakeSubsystem intakeSubsystem2, XboxController p2Controller) {
        //TODO Auto-generated constructor stub
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
