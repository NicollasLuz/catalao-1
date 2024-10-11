package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants.MotorId;

public class IntakeSubsystem extends SubsystemBase {
    
    public static CANSparkMax intakemotor1, intakemotor2;

    public IntakeSubsystem(){
    intakemotor1 =
     new CANSparkMax(MotorId.INTAKE_PORT,MotorType.kBrushless);

     intakemotor2 =
     new CANSparkMax(MotorId.INTAKE2_PORT,MotorType.kBrushless);
    }

    public void setIntakeSpeed(double speed) {
        intakemotor1.set(speed);
        intakemotor2.set(speed);
      }
}
