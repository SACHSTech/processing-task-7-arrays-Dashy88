import processing.core.PApplet;

public class Sketch extends PApplet {
  
  float[] snowY = new float[40];
  float[] snowGround = new float[40];

  int arraynum = 35;
  int[] posX = new int[arraynum];
  int[] posY = new int[arraynum];
  int index = 0;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {

	// size call
    size(400, 400);
    for (int i = 0; i < snowY.length; i++) {
      snowY[i] = random(height);
    }
  }
  
  // called at beginning of execution
  public void setup() {
    
    background(50, 120, 135);
    noStroke();
    for (int i = 0; i < 30; i++){
      snowGround[i] = 5;
    }
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    
    background(0);

    fill(242);
    if (keyCode == UP){
      for (int i = 0; i < snowY.length; i++) {
        float circleX = width * i / snowY.length;
        ellipse(circleX, snowY[i], 15, 15);

        snowY[i] += 3;

        if (snowY[i] > height) {
          snowY[i] = 0;
          snowGround[i] += 5;
        }
      }
    } else if (keyCode == DOWN) {
      for (int i = 0; i < snowY.length; i++) {
        float circleX = width * i / snowY.length;
        ellipse(circleX, snowY[i], 15, 15);

        snowY[i]++;

        if (snowY[i] > height) {
          snowY[i] = 0;
          snowGround[i] += 5;
        }
      }
    } else {
      for (int i = 0; i < snowY.length; i++) {
        float circleX = width * i / snowY.length;
        ellipse(circleX, snowY[i], 15, 15);

        snowY[i] +=4;

        if (snowY[i] > height) {
          snowY[i] = 0;
          snowGround[i] += 6;
        }
      }
    }

    for (int i = 0; i < 30; i++){
      fill(255);
      rect(i*14, height-snowGround[i], 8, height);
    }

    fill(253,102);
    posX[index] = mouseX;
    posY[index] = mouseY;
    index = (index + 1) % arraynum;

    for (int i = 0; i < arraynum; i++) {
      int pos = (index + i) % arraynum;
      ellipse(posX[pos], posY[pos], i, i);
    }
  }
}
