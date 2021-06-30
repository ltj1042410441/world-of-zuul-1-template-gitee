package cn.edu.whut.sept.zuul;

/**
 *主类，调用Game类创建game实例，并调用实例的play函数开始游戏
 */
public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
