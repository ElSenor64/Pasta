package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Encompasser {
    public enum EnStates {
        ENTAKE, STATIONARY, EXTAKE
    }

    EnStates enState;
    private WPI_TalonSRX encompLMoto;
    private WPI_TalonSRX encompRMoto;

    public Encompasser() {
        enState = EnStates.STATIONARY;
        encompLMoto = new WPI_TalonSRX(Constants.ENCOM_LMOTO_PORT);
        encompRMoto = new WPI_TalonSRX(Constants.ENCOM_RMOTO_PORT);
    }

    public void kirby(double nomInp){
        switch(enState){
            case STATIONARY:
                if(nomInp < -0.15) {
                
                    encompLMoto.set(nomInp);
                    encompRMoto.set(nomInp * -1);
                    enState = EnStates.ENTAKE;
                }
                else if(nomInp > 0.15) {
                
                    encompLMoto.set(nomInp);
                    encompRMoto.set(nomInp * -1);
                    enState = EnStates.EXTAKE;
                }
                break;
            case ENTAKE:
                if(nomInp >= -0.15 && nomInp <= 0.15) {
                    
                    encompLMoto.set(0);
                    encompRMoto.set(0);
                    enState = EnStates.STATIONARY;
                }
                break;
            case EXTAKE:
                if(nomInp >= -0.15 && nomInp <=         0.15) {
                    
                    encompLMoto.set(0);
                    encompRMoto.set(0);
                    enState = EnStates.STATIONARY;
                }
                break;
        }

    }
}