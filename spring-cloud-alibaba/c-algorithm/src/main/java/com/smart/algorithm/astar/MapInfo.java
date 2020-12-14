package com.smart.algorithm.astar;

/**
 *
 * @version V1.0
 * @title: MapInfo
 * @description:
 * @author: lukewei
 * @date: 2020-12-14 13:59
 * @remark: 修改内容
 *
 * (4) 最后一个数据结构是A星算法输入的所有数据，封装在一起，传参方便。
 */
public class MapInfo {

    public int[][] maps; // 二维数组的地图
    public int width; // 地图的宽
    public int high; // 地图的高
    public Node start; // 起始结点
    public Node end; // 最终结点

    public MapInfo(int[][] maps, int width, int high, Node start, Node end)
    {
        this.maps = maps;
        this.width = width;
        this.high = high;
        this.start = start;
        this.end = end;
    }
}
