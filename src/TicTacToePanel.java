import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

public class TicTacToePanel extends JPanel implements MouseListener {
    private TicTacToeGame game;
    private Image x, o;

    public TicTacToePanel() {
        this.setPreferredSize(new Dimension(300, 300));
        this.addMouseListener(this);
        game = new TicTacToeGame();
        
        try {
        	x= ImageIO.read(new File("images/x.png"));
        	o= ImageIO.read(new File("images/o.png"));
        }catch(IOException e) {
        	System.out.print("Error"+ e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();

        // Draw grid
        g.drawLine(w / 3, 0, w / 3, h);
        g.drawLine(2 * w / 3, 0, 2 * w / 3, h);
        g.drawLine(0, h / 3, w, h / 3);
        g.drawLine(0, 2 * h / 3, w, 2 * h / 3);

        // TODO: Draw X and O using game.getSymbolAt(row, col)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char symbol = game.getSymbolAt(row, col);
                int cellWidth = w / 3;
                int cellHeight = h / 3;
                int xPos = col * cellWidth;
                int yPos = row * cellHeight;

                if (symbol == 'X') {
                    g.drawImage(x, xPos, yPos, cellWidth, cellHeight, null);
                } else if (symbol == 'O') {
                    g.drawImage(o, xPos, yPos, cellWidth, cellHeight, null);
                }
            }  
            
               
        }
        }

        
    

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = e.getY() / (getHeight() / 3);
        int col = e.getX() / (getWidth() / 3);

        // TODO: Call game.makeMove and repaint
        // Optionally check for winner and show message
        if (game.makeMove(row, col)) {
            repaint();
            char winner = game.checkWinner();
            if (winner != '\0') {
                JOptionPane.showMessageDialog(this, winner + " wins!");
                game.reset();
                repaint();
            } else if (game.isDraw()) {
                JOptionPane.showMessageDialog(this, "Draw!");
                game.reset();
                repaint();
            }
        }

    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}