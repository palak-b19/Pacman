import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import java.awt.Color;
import java.awt.Font;
public class frames extends JFrame{
    frames(){
        JLabel label = new JLabel();

        ImageIcon image = new ImageIcon( "D:\\Wallpapers\\OIP (2).jfif");
        Border border = BorderFactory.createLineBorder(Color.CYAN, 7);
        label.setBorder( border );

        label.setText("Staisha");
        label.setForeground(Color.WHITE);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(  JLabel.BOTTOM);
        label.setFont( new Font("MV Boli"  , Font.BOLD, 25)  );
        label.setIconTextGap( -40 );
        label.setBackground( new Color( 30 , 30 , 60));
        
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        label.setIcon( image );
        
        label.setOpaque(true);

        this.add(label);
        this.setTitle("Lol");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(400, 400);
        this.setIconImage(image.getImage());
        //this.getContentPane().setBackground( new Color(0,0,0));
        //label.setFont(" ");
        
        this.setSize( 400 , 400 );
        this.setVisible(true);
        //this.pack();
        this.setLayout(null);

    }
}
