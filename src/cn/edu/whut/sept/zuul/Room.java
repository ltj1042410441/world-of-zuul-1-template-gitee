package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;

/**
 *该类是用来创建房间实例
 */
public class Room
{
    /**
     *定义了对房间的描述和对出口与房间的关系的哈希表
     */
    private String description;
    private HashMap<String, Room> exits;

    /**
     *类的构造函数，创建房间并增加对房间的描述
     * @param description 描述房间的属性，由系统自动生成
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * 将房间与出口的关系存入HashMap中
     * @param direction 键值对的key值，表示对房间的描述
     * @param neighbor 键值对的value值，表示房间的出口
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     *获得房间的描述
     * @return 返回的是该实例的desciption属性
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * 此函数用于在游戏过程中对所处位置的描述
     * @return 返回的是“You are‘所在地点’（换行）‘所有出口’”的字符串
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * 此方法用于获取该房间的出口
     * @return 返回的是包含该房间所有的出口的字符串
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * 此方法用于找到出口的方向
     * @param direction 房间的属性
     * @return 返回的是房间可以前进的方向
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
}


