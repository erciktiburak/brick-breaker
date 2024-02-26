import javax.swing.JFrame;

public class BrickBreakerGame extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public BrickBreakerGame() {
        setTitle("Brick Breaker Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setResizable(false);

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BrickBreakerGame();
    }
}