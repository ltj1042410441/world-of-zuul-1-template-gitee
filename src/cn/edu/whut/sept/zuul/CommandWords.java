package cn.edu.whut.sept.zuul;

/**
 * 此类是对命令的判别，用来判定用户输入的命令是否属于合法命令
 *
 *
 *
 */
public class CommandWords
{
    /**
     *有效词汇，提前声明好仅go、quit、help为有效词汇，他们为commandword的firstword时命令才有效
     */
    private static final String[] validCommands = {
            "go", "quit", "help"
    };

    /**
     *构造函数
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     *用来判断用户的输入是否为不合法命令，只对第一个词进行了判断，不能断定是否合法
     * @param aString 用户输入的字符串
     * @return 如果用户输入的第一个字符串与提前定义好的合法命令相同则返回1，否则返回0（即命令不合法）
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }

    /**
     *输出所有的合法词汇
     */
    public void showAll()
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
