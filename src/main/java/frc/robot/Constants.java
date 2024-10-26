// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;
import swervelib.math.SwerveMath;
import swervelib.parser.PIDFConfig;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final class MotorId{

    //Porta dos  motores
    public static final int INTAKE_PORT = 19;
    public static final int INTAKE2_PORT = 20;
  }

  public static final class Controle {

    // Porta do controle
    public static final int P1PORT = 0;
    public static final int P2PORT = 1;

    //Deadband do controle

    public static final double DEADBAND = 0.2;

  }

  public static final class StateStrings{

    public static final String OFF = "OFF";
    public static final String ON = "ON";
  }

  public static final class Dimensoes{

    //Tempo do loop (sparkmax + normal = 130ms)
    public static final double LOOP_TIME = 0.13;

    //Massa do robô
    public static final double ROBOT_MASS = 38;

    //Posições do centro de masssa

    public static final double MASS_X = 0;
    public static final double MASS_Y = 0;
    public static final double MASS_Z = .08;

    //Centro de massa do chassi

    public static final Matter CHASSIS = new Matter(
      new Translation3d(MASS_X, MASS_Y, MASS_Z), ROBOT_MASS);

      //Máxima aceleração e velocidade
    public static final double MAX_ACCE_AUTO = 4;
    public static final double MAX_VEL_AUTO = 4;

    //Diâmetro da roda do módulo 
    
    public static final double WHELL_DIAMETER_IN_METERS = Units.inchesToMeters(4);
    
    //Redução para motor de  acionamento e ângulo 

    public static final double DRIVE_GEAR_RATIO = 6.18;
    public static final double ANGLE_GEAR_RATIO = 21.42;

    //PRR do encoder interno NEO

    public static final double PULSE_PER_ROTATION = 1;

    //Fatores de conversão para motores de acionamento e ângulo 

    public static final double DRIVE_CONVERSION = SwerveMath.calculateMetersPerRotation(
      WHELL_DIAMETER_IN_METERS,
      DRIVE_GEAR_RATIO,
      PULSE_PER_ROTATION
      );

      public static final double ANGLE_CONVERSION = SwerveMath.calculateDegreesPerSteeringRotation(
        WHELL_DIAMETER_IN_METERS,
        PULSE_PER_ROTATION
      );
  }

  //Classe que contém os PID do autônomo 
  public static final class PID{

    //PID para frente e para trás 
    public static final PIDFConfig X_AUTO_PID = new PIDFConfig(0.65,0, 0.05);

    //PID para esquerda e direita
    public static final PIDFConfig Y_AUTO_PID = new PIDFConfig(0.6,0,0);

    //PID de rotação
    public static final PIDFConfig ANGLE_AUTO_PID = new PIDFConfig(0.4,0,0.01);

  }

  public static final class Tracao{

    //Define se a tração vai ser orientada ao campo
      public static final boolean FIEL_RELATIVE = true;

    //false para malha-fechada
      public static final boolean IS_OPEN_LOOP = false;

    //true para correção de aceleração 
      public static final boolean ACCEL_CORRECTION = false;

      public static final double TURN_CONSTANT = 0.75;

    //Constante que define a velocidade máxima 

    public static final double MAX_SPEED = 4;
    
    //Deadband do controle na tração
    public static final double DT = 0.02;
    
    public static final double CONSTANT_ROTATION = 4;
    
    
  }


}
