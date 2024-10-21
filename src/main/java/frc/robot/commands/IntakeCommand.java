package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends Command{
    
private final IntakeSubsystem intakeSubsystem;
private final XboxController p2Controller;

    public IntakeCommand(
        IntakeSubsystem intakeSubsystem, 
        XboxController p2Controller
    ){
         this.p2Controller = p2Controller;
         this.intakeSubsystem = intakeSubsystem;
        
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

    public void IntakeExpelir(){
        intakeSubsystem.setIntakeSpeed
        (-0.1);
    }

    @Override
    public void execute(){
        if (p2Controller.getRightTriggerAxis() != 0) {
            intakeSubsystem.setIntakeSpeed(-0.5);    
        } else if (p2Controller.getLeftTriggerAxis() != 0){
                intakeSubsystem.setIntakeSpeed(0.3);
        }
        else {
            intakeSubsystem.setIntakeSpeed(0);
        }
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
