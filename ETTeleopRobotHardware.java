package org.firstinspires.ftc.teamcode.etrobot;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by RobotChicken on 11/1/2016.
 */

public class ETTeleopRobotHardware {
    /* Public OpMode members. */
    public DcMotor leftFrontMotor   = null;
    public DcMotor rightFrontMotor  = null;
    public DcMotor leftBackMotor  = null;
    public DcMotor rightBackMotor = null;
    public DcMotor armMotor    = null;
    public ModernRoboticsI2cGyro gyro    = null;                    //
    //public Servo leftClaw    = null;
   // public Servo    rightClaw   = null;

   // public static final double MID_SERVO       =  0.5 ;
    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public ETTeleopRobotHardware(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftFrontMotor   = hwMap.dcMotor.get("left_front_drive");
        rightBackMotor  = hwMap.dcMotor.get("right_front_drive");
        leftBackMotor = hwMap.dcMotor.get("left_back_drive");
        rightBackMotor = hwMap.dcMotor.get("right_back_drive");
        //armMotor    = hwMap.dcMotor.get("left_arm");
        gyro = (ModernRoboticsI2cGyro)hwMap.gyroSensor.get("gyro");
        //leftFrontMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        //rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        //leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
        //rightBackMotor.setDirection(DcMotor.Direction.FORWARD);

        // Set all motors to zero power
        leftFrontMotor.setPower(0.0);
        rightFrontMotor.setPower(0.0);
        leftBackMotor.setPower(0.0);
        rightBackMotor.setPower(0.0);
        //armMotor.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize ALL installed servos.
       // leftClaw = hwMap.servo.get("left_hand");
        // rightClaw = hwMap.servo.get("right_hand");
        //leftClaw.setPosition(MID_SERVO);
       // rightClaw.setPosition(MID_SERVO);


    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     */
    public void waitForTick(long periodMs) {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}
