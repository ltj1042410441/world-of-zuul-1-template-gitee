package cn.edu.whut.sept.zuul;

/**
 *启动游戏用的类，调用Game类创建game实例，并调用实例的play函数开始游戏.
 */
public class  Main {

    public static void main(final String[] args) {
        Game game = new Game();
        game.play();
    }
}
