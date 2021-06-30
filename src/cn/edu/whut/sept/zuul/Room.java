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
     *
     * @param description
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     *
     * @param direction
     * @param neighbor
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     *
     * @return
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     *
     * @return
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     *
     * @return
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
     *
     * @param direction
     * @return
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
}


