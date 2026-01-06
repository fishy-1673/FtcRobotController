//Version 25-26 2.4.2
package org.firstinspires.ftc.teamcode.systems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Indexer {
    private Servo Index;
    private Servo Ejector;
    private Double[] InPos = {0.45,0.0,0.90,};
    public Indexer(HardwareMap hardwareMap) {//maybye define a local hardware map with  this.hardwareMap = hardwareMap;  ?
        Index = hardwareMap.get(Servo.class, "Is");
        Ejector = hardwareMap.get(Servo.class, "Es");
    }


    public void Index(int pos) {
        if (pos<4&&pos>=0) Index.setPosition(InPos[pos]);
    }
    public void Eject(boolean i){
        if (!i) Ejector.setPosition(0.53);
        else  Ejector.setPosition(0.29);
    }
    public String getTel() {
        return ("Index Pos: " + Index.getPosition()+" ");
    }

    }
