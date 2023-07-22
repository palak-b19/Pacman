package pacman;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class tut1 extends JPanel implements ActionListener {
    
    Dimension d; // sets height n width of the playing field
    Font font_for_game = new Font("Arial", Font.ITALIC, 14);
    boolean game_check = false; // to check if game is started or not
    boolean dying = false;

    int BLOCK_SIZE = 24 , Blocks_1D = 15;
    int Screen_size = Blocks_1D * BLOCK_SIZE;
    int Max_ghosts = 12 , Pacman_speed = 6;

    int ghosts = 6 , lives , score;
    int[] dx , dy , ghost_x , ghost_y , ghost_dx , ghost_dy , ghostspeed;

    Image heart , ghost , up , down , left , right;

    int pacman_x , pacman_y , pacman_dx , pacman_dy , req_dx , req_dy;
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
        ghost = new ImageIcon("C:\\Users\\Shrutya\\Downloads\\images\\ghost.gif").getImage();
        heart = new ImageIcon("C:\\Users\\Shrutya\\Downloads\\images\\heart.gif").getImage();        
    }

    void initVariables(){
        screen_data = new short[ Blocks_1D * Blocks_1D];
        d = 
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
       
}
