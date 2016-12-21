package org.firstinspires.ftc.teamcode.etrobot;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.robotcontroller.external.samples.PushbotTeleopTank_Iterative;

/**
 * Created by megan on 10/25/2016.
 */
@TeleOp(name="Robot: Teleop ET", group="ET Robot")
public class ETTeleopFourWheel extends PushbotTeleopTank_Iterative {
    ETTeleopRobotHardware robot       = new ETTeleopRobotHardware(); // use the class created to define a Pushbot's hardware
    boolean isArmMotorRunning = false;

    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello ET Driver");    //
    }
    @Override
    public void loop() {
        double leftFront;
        double rightFront;
        double forwardArm;


        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        leftFront = -gamepad1.left_stick_y;
        rightFront = -gamepad1.right_stick_y;


        robot.leftFrontMotor.setPower(leftFront);
        robot.rightFrontMotor.setPower(-rightFront);

        forwardArm = -gamepad2.left_stick_y;


        robot.armMotor.setPower(forwardArm);
           //detect if B button is pressed
        //find out previous state of armMotor (at rest or running)
        //toggle armMotor (if at rest, run; if running, stop)
        //adjust power of 2.0 as needed

 = true;,

            }
        }
        if (gamepad2.y){
            robot.armMotor.setPower(-10);
            isArmMotorRunning = true;
        }*/

        // Send telemetry message to signify robot running;
        telemetry.addData("left_front",  "%.2f", leftFront);
        telemetry.addData("right_front", "%.2f", rightFront);

    }

}

