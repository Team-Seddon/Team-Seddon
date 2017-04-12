/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teamseddon
 */
public class VOR {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println((260 + 110) %360);
    }
    //This object represents an OBS system.
    public class OBS{
            private int radial = 0;
            private String tofrom = "";
            private boolean signalstrength = true;
            private int linkedfrequency = 0;
        public OBS(){
            
        }
        //sets radial value which is the value of intended direction
        public void setRadial(int number){
            radial = number;
        }
        //sets radial value which is the value of intended direction
        public int getRadial(){
            return radial;
        }
                //sets radial value which is the value of intended direction
        public void chkSignalStrength(boolean good){
            signalstrength = good;
        }

        /*gets the TOFROM flag to true if it's to and false if it's false
        depending on if it's on the upper quadrants of tower or lower quadrants of
        the tower respective*/
        public String chkToFrom(VORTower tower){
            if(getRadial() < 90){
                if(((tower.getRadial()> (270 + getRadial())) && tower.getRadial() <= 360) || (tower.getRadial()>= 0) && (tower.getRadial() < 90 + getRadial())){
                    return "FROM";
                }
                else{
                    return "TO";
                }
            }
            else if(getRadial() >= 180){
                if(((tower.getRadial()> (270 + getRadial())) && tower.getRadial() <= 360) || (tower.getRadial()>= 0) && (tower.getRadial() < 90 + getRadial())){
                    return "TO";
                }
                else{
                    return "FROM";
                }                
            }
            else{
                if(tower.getRadial()> ((270 + getRadial()) % 360) && tower.getRadial() < (90 + getRadial())){
                    return "FROM";
                }
                else{
                    return "TO";
                }
            }
            
        }
        public int chkDeflection(VORTower tower){
            if(chkToFrom(tower) == "TO"){
                if((tower.getRadial() - 180) % 360 < getRadial()){
                    if((tower.getRadial() - 180) % 360 >= ((tower.getRadial() - 180) % 360) + 11 ){
                        System.out.println("deflection needle is -11 to the left please turn left");
                        return -11;
                    }
                    else{
                        System.out.println("deflection needle is " + (((tower.getRadial() - 180) % 360) - getRadial()) + " to the left please turn left");
                        return getRadial() -((tower.getRadial() - 180) % 360) - getRadial() ;
                    }
                }
                else{
                    if((tower.getRadial() - 180) % 360 < ((tower.getRadial() - 180) % 360) - 11 ){
                        System.out.println("deflection needle is -11 to the right please turn right");
                        return -11;
                    }
                    else{
                        System.out.println("deflection needle is " + (((tower.getRadial() - 180) % 360) - getRadial()) + " to the left please turn left");
                        return getRadial() -((tower.getRadial() - 180) % 360) - getRadial();
                    }
                }
            }
            else{
                if((tower.getRadial() - 180) % 360 < getRadial()){
                                        if((tower.getRadial() - 180) % 360 >= ((tower.getRadial() - 180) % 360) + 11 ){
                        System.out.println("deflection needle is -11 to the left please turn left");
                        return -11;
                    }
                    else{
                        System.out.println("deflection needle is " + (((tower.getRadial() - 180) % 360) - getRadial()) + " to the left please turn left");
                        return getRadial() -((tower.getRadial() - 180) % 360) - getRadial() ;
                    }
                }
            }
            return 0;
        }
        public boolean linkTower(VORTower tower, int frequency){
            if(frequency == tower.getFrequency()){
                linkedfrequency = tower.getFrequency();
                System.out.println("Tower Linked on frequency: " + linkedfrequency);
             return true;   
            }
            else{
                return false;
            }
        }
        public int getTowerRadial(VORTower tower){
            return tower.getRadial();
        }
    }
    //This class object represent the VOR Tower which will relay planes positionn.
    public class VORTower{
        int towerfrequency;
        int radial;
        public VORTower(int frequency, int radial){
            towerfrequency = frequency;
        }
        //sets radial value which is the position of the plane to the tower.
        public void setRadial(int number){
            radial = number;
        }
        //sets radial value which is the position of the plane to the tower
        public int getRadial(){
            return radial;
        }
        public int getFrequency(){
            return towerfrequency;
        }
    }
}
