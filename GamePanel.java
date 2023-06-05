package main;
import  javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends  JPanel implements Runnable{

    //Screen settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;

    final int tileSize = originalTileSize*scale; //48*48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize*maxScreenCol;  //768 pixels
    final int screenHeight = tileSize*maxScreenRow; //576 pixels

    KeyHandler keyH = new KeyHandler();

    Thread gameThread;

    //set olayer's default positioms
    int playerx= 100;
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run(){

        while(gameThread != null) {
        //    System.out.println("The game loop is running");
        //update char position
            //draw screen the information
        update();
        repaint();

        }
    }
    public void update(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);

        g2.fillRect(100,100,tileSize,tileSize);

        g2.dispose();
    }
}
