package catch_the_drop;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private static GameWindow game_window;

    public static void main(String[] args) {
        game_window = new GameWindow();//Создание объекта
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Закрытие программы при закрытии программы :-)
        game_window.setLocation(200, 100);//Позиция окна на экране
        game_window.setSize(906, 478);//Размер окна
        game_window.setResizable(false);//Запрет на измение размера окна
        GameField game_field = new GameField();
        game_window.add(game_field);
        game_window.setVisible(true);//Теперь окно видимо

    }

    private static void onRepaint(Graphics g) {//Здесь можно рисовать
        g.fillOval(10, 10, 200, 100);
        g.drawLine(10, 10, 300, 200);
    }

    private static class GameField extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
        }
    }
}
