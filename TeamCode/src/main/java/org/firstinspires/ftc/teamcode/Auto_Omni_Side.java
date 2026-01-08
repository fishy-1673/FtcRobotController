
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.systems.DriveTrain;
import org.firstinspires.ftc.teamcode.systems.Indexer;
import org.firstinspires.ftc.teamcode.systems.Intake;
import org.firstinspires.ftc.teamcode.systems.Launcher;


@Autonomous(name="Auto Omni side", group="Robot")

public class Auto_Omni_Side extends LinearOpMode {

    /* Declare OpMode members. */

    public void Wait(double time, String Telemetry){
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < time)) {

            telemetry.addLine(Telemetry+"time: " + runtime.seconds());

            telemetry.update();
        }
    }
    private ElapsedTime     runtime = new ElapsedTime();



    @Override
    public void runOpMode() {

        // Initialize the drive system variables.
       DriveTrain omni = new DriveTrain(hardwareMap);
        Launcher Shoot = new Launcher(hardwareMap);
        Indexer Index = new Indexer(hardwareMap);
        Intake Intake = new Intake(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();


        // Step 1:  Drive forward for 3 seconds
        Shoot.speed(1);
        Index.Index(0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.0)) {
            telemetry.addData("spedup", "Leg 1: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }


        runtime.reset();
        Index.Eject(true);
        while (opModeIsActive() && (runtime.seconds() < 0.27)) {

            telemetry.addData("shooting", "Leg 2: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        Index.Eject(false);


        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.15)) {
            telemetry.addData("wait", "Leg 3: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        Index.Index(1);
        Wait(0.3,"Indexing");
        Index.Eject(true);
        Wait(0.2,"Shooting");
        Index.Eject(false);

        Wait(0.2,"Wait");
        Index.Index(2);
        Wait(0.3, "Indexing");
        Index.Eject(true);
        Wait(0.2,"Shooting");
        Index.Eject(false);
        Wait(0.2,"wait");
        omni.Drive(1,0,0);
        Wait(1,"Driving");
        omni.Drive(0,0,0);







        // Step 3:  Drive Backward for 1 Second




        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}
