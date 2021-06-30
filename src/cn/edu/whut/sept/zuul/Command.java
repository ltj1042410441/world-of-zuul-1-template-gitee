package cn.edu.whut.sept.zuul;
/**
 * 该类是用于接收用户输入的命令词汇以及对用户所输入的词汇的一些判断.
 */
public class Command {
    /**
     * @param commandWord 由解析解析出来的第一个词汇，含义是命令词汇，由用户输入的
     */
    private String commandWord;
    /**
     * @param secondWord 接收到的第二个词汇，只能用于go命令，其他时候无意义
     */
    private String secondWord;

    /**
     *创建.
     * @param firstWord 用户输入的第一个词汇，其含义是命令词汇，由用户输入
     * @param secondWord 用户输入的第二个词汇，只有在firstword是go的时候才有作用，由用户输入
     */
    public Command(final String firstWord, final String secondWord) {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * 返回commandWord.
     * @return 得到用户输入的第一个词汇
     */
    public String getCommandWord() {

        return commandWord;
    }

    /**
     *返回SecongWord.
     * @return 得到用户输入的第二个字符
     */
    public String getSecondWord() {

        return secondWord;
    }

    /**
     *判断用户是否输入词汇，如果没有返回错误.
     * @return 有词汇是返回值为0，没有词汇时返回值是1
     */
    public boolean isUnknown() {

        return (commandWord == null);
    }

    /**
     *判断输入是否有第二个词.
     * @return 有返回1，没有返回0
     */
    public boolean hasSecondWord() {

        return (secondWord != null);
    }
}
