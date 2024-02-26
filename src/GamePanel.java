import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {

    private final int paddleWidth = 100;
    private final int paddleHeight = 20;
    private final int ballSize = 20;
    private int paddleSpeed = 5;

    private int paddleX = (BrickBreakerGame.WIDTH - paddleWidth) / 2;
    private int paddleY = BrickBreakerGame.HEIGHT - 50;

    private int ballX = BrickBreakerGame.WIDTH / 2 - ballSize / 2;
    private int ballY = BrickBreakerGame.HEIGHT / 2 - ballSize / 2;
    private int ballXSpeed = 1;
    private int ballYSpeed = 1;
    public void movePaddleLeft() {
        paddleX -= paddleSpeed;
        if (paddleX < 0) {
            paddleX = 0;
        }
    }

    public void movePaddleRight() {
        paddleX += paddleSpeed;
        if (paddleX > BrickBreakerGame.WIDTH - paddleWidth) {
            paddleX = BrickBreakerGame.WIDTH - paddleWidth;
        }
    }
    public GamePanel() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    movePaddleLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    movePaddleRight();
                }
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPaddle(g);
        drawBall(g);
    }

    private void drawPaddle(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);
    }

    public void moveBall() {
        ballX += ballXSpeed;
        ballY += ballYSpeed;

        if (ballX < 0 || ballX > BrickBreakerGame.WIDTH - ballSize) {
            ballXSpeed = -ballXSpeed;
        }

        if (ballY < 0 || ballY > BrickBreakerGame.HEIGHT - ballSize) {
            ballYSpeed = -ballYSpeed;
        }
    }

    private void drawBall(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, ballSize, ballSize);
    }
}
