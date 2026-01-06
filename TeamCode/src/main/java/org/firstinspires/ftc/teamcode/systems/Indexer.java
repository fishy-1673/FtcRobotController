//Version 25-26 2.5.8
package org.firstinspires.ftc.teamcode.systems;


import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Indexer {
    private Servo Index;
    private Servo Ejector;
    private Double[] EPos = {0.45,0.0,0.90,};
    private Double[] InPos = {0.5,0.97,0.075};
    public Indexer(@NonNull HardwareMap hardwareMap) {//maybye define a local hardware map with  this.hardwareMap = hardwareMap;  ?
        Index = hardwareMap.get(Servo.class, "Is");
        Ejector = hardwareMap.get(Servo.class, "Es");
    }


    public void Index(int pos) {
        if (pos<4&&pos>=0) Index.setPosition(EPos[pos]);
    }
    public void Load(int pos) {
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
