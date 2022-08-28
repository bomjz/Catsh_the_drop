package catch_the_drop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame {

    private static GameWindow game_window;
    private static long last_frame_time;
    private static Image background1;
    private static Image game_over;
    private static Image drop;
    private static float drop_left = 500;
    private static float drop_top = -100;
    private static float drop_v = 100;//Скорость капли


    public static void main(String[] args) throws IOException {
        //Инициализируем картинки в экран
        background1 = ImageIO.read(GameWindow.class.getResourceAsStream("background1.png"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));

        game_window = new GameWindow();//Создание объекта
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Закрытие программы при закрытии программы :-)
        game_window.setLocation(0, 0);//Позиция окна на экране
        game_window.setSize(1906, 1478);//Размер окна
        game_window.setResizable(false);//Запрет на измение размера окна
        last_frame_time = System.nanoTime(); //Возврат текущего времени в наносекундах
        GameField game_field = new GameField();
        game_window.add(game_field);
        game_window.setVisible(true);//Теперь окно видимо

    }

    private static void onRepaint(Graphics g) {//Здесь можно рисовать
        long current_time = System.nanoTime();
        float delta_time = (current_time - last_frame_time) * 0.000000001f;
        last_frame_time = current_time;

        drop_top = drop_top + drop_v * delta_time;
        g.drawImage(background1, 0, 0, null);
        g.drawImage(drop, (int) drop_left, (int) drop_top, null);
//        g.drawImage(game_over,280,120,null);
    }

    private static class GameField extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint(); //отрисовка снова и снова
        }
    }
}
