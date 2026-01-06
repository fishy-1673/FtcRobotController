//Version 25-26 2.2.2
package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.systems.DriveTrain;
import org.firstinspires.ftc.teamcode.systems.Indexer;
import org.firstinspires.ftc.teamcode.systems.Intake;
import org.firstinspires.ftc.teamcode.systems.Launcher;

import java.util.List;


@TeleOp(name="OmniDrive", group="Linear OpMode")

public class OmniDrive extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();

    boolean unlockedSP = true;
    boolean islockIS = false;
    double SP;
    double FS;

    @Override
    public void runOpMode() {
        DriveTrain Omni = new DriveTrain(hardwareMap);
        Launcher Shoot = new Launcher(hardwareMap);
        Intake Take = new Intake(hardwareMap);
        Indexer Index = new Indexer(hardwareMap);
        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        runtime.reset();

        Take.OSS(true);

        while (opModeIsActive()) {


            double dly = -gamepad1.left_stick_y;
            double dlx =  gamepad1.left_stick_x;
            double drx =  gamepad1.right_stick_x;
            double clt = gamepad2.left_trigger;
            double crt = gamepad2.right_trigger;
            double  drt = gamepad1.right_trigger;
            double dlt = gamepad1.left_trigger;
            Omni.Drive(dly, dlx, drx);
            if(unlockedSP){
                SP = clt;
                Shoot.speed(SP);
            }
            if (gamepad2.yWasPressed()){
                unlockedSP = !unlockedSP;
            }
            if (gamepad1.xWasPressed()){
                islockIS = !islockIS;}
            if (!islockIS){
                Take.intakeSpeed(drt-dlt);
            }
            if (gamepad2.dpad_up) Index.Index(0);
            else if (gamepad2.dpad_left) Index.Index(1);
            else if (gamepad2.dpad_right) Index.Index(-1);
            //adjust to add in a zone that the trigger will fire in, reduces sensitivity to be boolean
            Index.Eject(crt>0.85);

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addLine(Omni.getTel() + " unlocked LT: " + unlockedSP + Shoot.getTel());
            telemetry.update();
        }
    }}
