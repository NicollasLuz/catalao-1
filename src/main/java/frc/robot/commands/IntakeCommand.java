package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.Constants.Buttons;
import frc.robot.Constants.Intake;
import frc.robot.Constants.Intake.IntakeMode;

public class IntakeCommand extends Command{
    
private final IntakeSubsystem intakeSubsystem;
private final XboxController p2Controller;
private IntakeMode intakeMode;

    public IntakeCommand(
        IntakeSubsystem intakeSubsystem, 
        XboxController p2Controller
    ) {
            this.p2Controller = p2Controller;
            this.intakeSubsystem = intakeSubsystem;
        
            addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize(){
        intakeMode = IntakeMode.INSIDE;
    }

    @Override
    public void execute(){
         SmartDashboard.putString("Modo Intake", intakeMode.toString());

        if(p2Controller.getRawButton(Buttons.BUTTON_Y)){
            intakeMode = IntakeMode.INSIDE;
        }else if (p2Controller.getRawButton(Buttons.BUTTON_A)){
            intakeMode = IntakeMode.COLLECT;
        }else if (p2Controller.getRawButton(Buttons.BUTTON_B)){
            intakeMode = IntakeMode.DEPOSIT;
        }

        switch (intakeMode) {
            case INSIDE:
                intakeSubsystem.setIntakePosition(Intake.INSIDE_POSITION);
                break;
            case COLLECT:
                intakeSubsystem.setIntakePosition(Intake.COLLECT_POSITION);
                break;
            case DEPOSIT:
                intakeSubsystem.setIntakePosition(Intake.DEPOSIT_POSITION);
                break;
        }

        if (p2Controller.getRightTriggerAxis() != 0) {
            intakeSubsystem.setIntakeSpeed(-0.5);    
        } else if (p2Controller.getLeftTriggerAxis() != 0){
            intakeSubsystem.setIntakeSpeed(0.3);
        }
        else {
            intakeSubsystem.setIntakeSpeed(0);
        }
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
    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
      }
}
