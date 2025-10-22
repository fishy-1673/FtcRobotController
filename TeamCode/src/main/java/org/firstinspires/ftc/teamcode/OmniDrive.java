//Version 25-26 1.2.2
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.systems.DriveTrain;
import org.firstinspires.ftc.teamcode.systems.Launcher;


@TeleOp(name="OmniDrive", group="Linear OpMode")

public class OmniDrive extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();

    boolean unlockedLT = true;
    double SP;

    @Override
    public void runOpMode() {
        DriveTrain Omni = new DriveTrain(hardwareMap);
        Launcher Shoot = new Launcher(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();


        while (opModeIsActive()) {


            double ly = -gamepad1.left_stick_y;
            double lx =  gamepad1.left_stick_x;
            double rx =  gamepad1.right_stick_x;
            double lt = gamepad1.left_trigger;

            Omni.Drive(ly,lx,rx);
            if(unlockedLT){
                SP = lt;
            }
            if (gamepad1.yWasPressed()){
                unlockedLT = !unlockedLT;
            }
            Shoot.speed(SP);

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addLine(Omni.getTel() + " unlocked LT: " + unlockedLT + Shoot.getTel());
            telemetry.update();
        }
    }}
