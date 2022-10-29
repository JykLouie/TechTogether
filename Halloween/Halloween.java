package Halloween;
import Halloween.StdDraw;
import java.awt.Color;

public class Halloween {
    public static final String allInt = "0123456789";

    public String solicitNCharsInput(int n) {
        String inputString = "";
        drawFrame(inputString);
        while(inputString.length() < n){
            if(!StdDraw.hasNextKeyTyped()){
                continue;
            }
            char str = StdDraw.nextKeyTyped();
            inputString = inputString + str;
            drawFrame(inputString);
            StdDraw.pause(50);
        }
        return inputString;
    }

    public void drawFrame(String s) {
        StdDraw.clear();
        StdDraw.clear(Color.black);
        StdDraw.setFont();
        StdDraw.setPenColor(Color.white);
        StdDraw.text(512000/2,512000/2,s);
        StdDraw.show();
        }

    public static void main(String args[]){
        Halloween world = new Halloween();
        boolean entered = false;
        StdDraw.setCanvasSize(1546,980);
        StdDraw.setScale(0,512000);
        StdDraw.setPenColor(Color.white);
        String number = "";
        while(!entered){
            StdDraw.clear(Color.black);
            StdDraw.text(512000/2,512000/2,"Please enter the number of ghost you want in the court(An integer!)");
            StdDraw.show();
            StdDraw.pause(3000);
            number = world.solicitNCharsInput(1);
            StdDraw.pause(1000);
            if(allInt.contains(number)){
                entered = true;
            }else{
                continue;
            }
        }
        Integer numofobjs = Integer.valueOf(number);
        objs[] objsList = new objs[numofobjs];
        for(int i = 0; i < numofobjs; i++){
            objs newobjs = new objs();
            objsList[i] = newobjs;
        }
        StdDraw.picture(256000, 256000, "background.png");
        StdDraw.enableDoubleBuffering();
        StdDraw.show();
        
        while(true){
            StdDraw.clear();
            StdDraw.picture(256000,256000,"background.png");
            for(int i = 0; i < numofobjs; i++){
                objsList[i].update2();
                StdDraw.picture(objsList[i].xpos, objsList[i].ypos, objsList[i].fileName);
            }
            StdDraw.show();
            StdDraw.pause(100);
        }
    }
}
