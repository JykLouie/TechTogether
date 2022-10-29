package Halloween;

import java.util.Random;

public class objs {
    double xpos;
    double ypos;
    double xvel;
    double yvel;
    String fileName;
    double t;
    double r;
    double Constant = 50;
    Random ran = new Random();

    public String ranFilename(){
        return "obj" + ran.nextInt(3) + ".png";
        }
    
    public int[] initPositionGen(){
        int[] pos = new int[2];
        int num1 = 0;
        int num2 = 0;
        while(num1 < 100000 && num2 < 100000){
            num1 = ran.nextInt(412000);
            num2 = ran.nextInt(412000);
        }
        pos[0] = num1;
        pos[1] = num2;
        return pos;
    }

    public int ranSpeed(){
        int speed = ran.nextInt(5120);
        while(speed < 1000){
            speed = ran.nextInt(5120);
        }
        if(speed % 2 == 0){
            return -speed;
        }
        return speed;
    }    
    
    public void update(){
        if(this.hitTheWall()){
            if(this.xpos < 0 || this.xpos > 512000){
                this.xvel = -this.xvel;
            }
            if(this.ypos < 0 || this.ypos > 512000){
                this.yvel = -this.yvel;
            }
        }
        this.xpos = this.xpos + this.xvel;
        this.ypos = this.ypos + this.yvel;
    }

    public void update2(){
        if(this.xpos < 0 || this.xpos > 512000){
            this.xvel = -this.xvel;
        }
        if(this.ypos < 0 || this.ypos > 512000){
            this.yvel = -this.yvel;
            this.Constant = -Constant;
            this.t = -t;
        }
    
            this.xpos = this.xpos + this.xvel;
            this.ypos = this.ypos - Constant * Math.pow(t, 2);
            this.t = this.t + 1;
        }
    
        public void update3(){
            if(this.xpos < 0 || this.xpos > 512000){
                this.xvel = -this.xvel;
            }
            if(this.ypos < 0 || this.ypos > 512000){
                this.yvel = -this.yvel;
                this.Constant = -Constant;
                this.t = -t;
            }
            boolean reachTheEnd = false;
            
            this.xpos = this.xpos + r * Math.cos(xvel) * t;
            this.ypos = this.ypos + r * yvel * Math.cos(yvel) * t;
            this.t = this.t + 1;
        }

    public boolean hitTheWall(){
        if(this.xpos < 0 || this.ypos < 0 || this.xpos > 512000 || this.ypos > 512000){
            return true;
        }
        return false;
    }

    public objs(){
        this.xpos = initPositionGen()[0];
        this.ypos = initPositionGen()[1];
        this.xvel = ranSpeed();
        this.yvel = ranSpeed();
        this.fileName = ranFilename();
        this.t = 0;
        this.Constant = Constant;
        this.r = 3.14;
    }

    public static void main(String args[]){
        objs objs1 = new objs();
        
        System.out.print(objs1.ranFilename());
    }
}
