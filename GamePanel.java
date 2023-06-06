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

    //FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();

    Thread gameThread;

    //set olayer's default positioms
    int playerX= 100;
    int playerY = 100;
    int playerSpeed = 4;

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

        double drawInterval = 1000000000/FPS;
        while(gameThread != null) {
            long currentTime=System.nanoTime();

            update();
            repaint();

        }
    }
    public void update(){

        if (keyH.upPressed == true){
            playerY -= playerSpeed;
        }
        else if(keyH.downPressed == true){
            playerY += playerSpeed;
        }
        else if (keyH.leftPressed ==true){
            playerX -= playerSpeed;
        }
        else if (keyH.rightPressed == true){
            playerX += playerSpeed;
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);

        g2.fillRect(playerX,playerY,tileSize,tileSize);

        g2.dispose();
    }
}
