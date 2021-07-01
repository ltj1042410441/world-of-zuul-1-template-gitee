package cn.edu.whut.sept.zuul;

/**
 * 定义一个供枚举类使用的接口类.
 */
public interface Action {
    /**
     * 需要重载的抽象函数，实际上应该做出的集中操作.
     * @param game 需要用到Game类中的相关操作
     * @param command 用来识别使用哪种操作
     * @return
     */
    boolean actions(Game game, Command command);
}
