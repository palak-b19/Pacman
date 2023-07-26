package pacman;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class tut1 extends JPanel implements ActionListener {
    
    Dimension d; // sets height n width of the playing field
    Font font_for_game = new Font("P22 Constructivist Pro", Font.ITALIC, 14); // is not working go to C drive n fix it !!!!!!!!!!!!!!!!!
    boolean game_check = false; // to check if game is started or not
    boolean dying = false;

    int BLOCK_SIZE = 24 , Blocks_1D = 15;
    int Screen_size = Blocks_1D * BLOCK_SIZE;
    int Max_ghosts = 12 , Pacman_speed = 6;

    int ghosts = 6 , lives , score;
    int[] dx , dy , ghost_x , ghost_y , ghost_dx , ghost_dy , ghostspeed;

    Image heart , ghost , up , down , left , right;

    int pacman_x , pacman_y , pacman_dx , pacman_dy , req_dx , req_dy;// all for pacman
    short levelData[] = {
    	19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
        17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
        0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
        19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
        17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
        17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
        17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
        17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
        17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
        21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
        17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
        17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
    };
    int validSpeeds[] = { 1, 2, 3 , 4, 6 ,8};
    int maxSpeed = 6 , currentSpeed = 3;

    short[] screen_data; 
    Timer timer;
    public tut1(){
        loadImages();
        initVariables();
        addKeyListener( new TAdapter() );
        setFocusable(true);
        initGame();
    }

    void loadImages(){
        down = new ImageIcon("C:\\Users\\Shrutya\\Downloads\\images\\down.gif").getImage();
        up = new ImageIcon("C:\\Users\\Shrutya\\Downloads\\images\\up.gif").getImage();
        left = new ImageIcon("C:\\Users\\Shrutya\\Downloads\\images\\left.gif").getImage();
        right = new ImageIcon("C:\\Users\\Shrutya\\Downloads\\images\\right.gif").getImage();
        ghost = new ImageIcon("C:\Users\palak\Downloads\pac-man-ghost.gif").getImage();
        heart = new ImageIcon("C:\\Users\\Shrutya\\Downloads\\images\\heart.gif").getImage();        
    }

    void initVariables(){
        screen_data = new short[ Blocks_1D * Blocks_1D];
        d = new Dimension(400, 400);
        ghost_x = new int [Max_ghosts];
        ghost_y = new int [Max_ghosts];
        ghost_dx = new int [Max_ghosts];
        ghost_dy = new int [Max_ghosts];
        dx = new int[4];
        dy = new int[4];

        timer = new Timer(40, this);
        timer.restart();        

    }

    void initGame(){
        lives = 3;
        score = 0;
        initlevel();
        ghosts = 6;
        currentSpeed = 3;
    }

    void initlevel(){
        for (int i = 0; i < Blocks_1D* Blocks_1D; i++) {
            screen_data[i] = levelData[i];
        }
    }

    void playGame( Graphics2D g2d){
        if (dying) {
            death();
        }
        else{
            movePacman();
            drawPacman( g2d );
            moveGhosts( g2d );
            checkMaze();
        }
    }

    void movePacman(){
        int pos;
        short ch;
        if(  )
    }

    void continuelevel(){ // defines position of the ghosts
        int dx = 1;
        int random;
        for (int i = 0; i < ghosts; i++) {
            ghost_y[i] = 4 * BLOCK_SIZE;
            ghost_x[i] = 4 * BLOCK_SIZE;
            ghost_dy[i] = 0;
            ghost_dx[i] = dx;
            dx = -dx;
            random = (int)(Math.random()*(currentSpeed + 1));

            if (random > currentSpeed) {
                random = currentSpeed;
            }

            ghostspeed[i] = validSpeeds[random];
        }

        pacman_x = 7 * BLOCK_SIZE;
        pacman_y = 11 * BLOCK_SIZE;
        pacman_dx = 0;
        pacman_dy = 0;
        req_dx = 0;
        req_dy = 0;
        dying = false;
    }

    void paintComponent( Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = ( Graphics2D ) g;
        g2d.setColor(( Color.black));
        g2d.fillRect(0, 0, d.width, d.height);

        drawMaze(g2d);
        drawScore(g2d);

        if( game_check){
            playGame(g2d);
        }
        else{
            showIntroScreen(g2d);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    class TAdapter extends KeyAdapter{
        public void keyPressed( KeyEvent e){
            int key = e.getKeyCode();

            if ( game_check ){
                if (key == KeyEvent.VK_LEFT) {
                    req_dx = -1;
                    req_dy = 0;
                }
                else if (key == KeyEvent.VK_RIGHT) {
                    req_dx = 1;
                    req_dy = 0;
                }
                else if (key == KeyEvent.VK_UP) {
                    req_dx = 0;
                    req_dy = -1;
                }
                else if (key == KeyEvent.VK_DOWN) {
                    req_dx = 0;
                    req_dy = 1;
                }
                else if (key == KeyEvent.VK_ESCAPE && timer.isRunning()) {
                    game_check = false;
                }
            }
            else{
                if (key == KeyEvent.VK_ESCAPE) {
                    game_check = true;
                    initGame();
                }
            }
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
       
}
