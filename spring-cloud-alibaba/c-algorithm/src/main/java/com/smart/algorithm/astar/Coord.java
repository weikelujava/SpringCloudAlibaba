package com.smart.algorithm.astar;

/**
 *
 * @version V1.0
 * @title: Coord
 * @description:
 * @author: lukewei
 * @date: 2020-12-14 13:58
 * @remark: 修改内容
 *
 * (2) 按照二维数组的特点，坐标原点在左上角，所以y是高，x是宽，y向下递增，x向右递增，我们将x和y封装成一个类，好传参，重写equals方法比较坐标(x,y)是不是同一个。
 */
public class Coord {

    public int x;
    public int y;

    public Coord(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (obj instanceof Coord)
        {
            Coord c = (Coord) obj;
            return x == c.x && y == c.y;
        }
        return false;
    }
}
