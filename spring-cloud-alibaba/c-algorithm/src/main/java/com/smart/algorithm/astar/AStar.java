package com.smart.algorithm.astar;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @version V1.0
 * @title: AStar
 * @description:
 * @author: lukewei
 * @date: 2020-12-14 13:58
 * @remark: 修改内容
 * <p>
 * A*搜寻算法俗称A星算法
 * 搜索两点之间最短距离
 * <p>
 * 1. 从起点 A 开始，并把它就加入到一个由方格组成的 open list( 开放列表 ) 中。
 * 这个 open list 有点像是一个购物单。当然现在 open list 里只有一项，它就是起点 A ，后面会慢慢加入更多的项。
 * Open list 里的格子是路径可能会是沿途经过的，也有可能不经过。基本上 open list 是一个待检查的方格列表。
 * <p>
 * 2.查看与起点 A 相邻的方格 ( 忽略其中墙壁所占领的方格，河流所占领的方格及其他非法地形占领的方格 ) ，
 * 把其中可走的 (walkable) 或可到达的 (reachable) 方格也加入到 open list 中。
 * 把起点 A 设置为这些方格的父亲 (parent node 或 parent square) 。当我们在追踪路径时，这些父节点的内容是很重要的。
 * <p>
 * 3. 把 A 从 open list 中移除，加入到 close list( 封闭列表 ) 中， close list 中的每个方格都是现在不需要再关注的。
 * 深绿色的方格为起点，它的外框是亮蓝色，表示该方格被加入到了 close list 。
 * 与它相邻的黑色方格是需要被检查的，他们的外框是亮绿色。每个黑方格都有一个灰色的指针指向他们的父节点，这里是起点 A 。
 */
public class AStar {

    /**
     * (1) 在算法里需要定义几个常量来确定：二维数组中哪个值表示障碍物、二维数组中绘制路径的代表值、计算G值需要的横纵移动代价和斜移动代价。
     */
    public final static int BAR = 1; // 障碍值
    public final static int PATH = 2; // 路径
    public final static int DIRECT_VALUE = 10; // 横竖移动代价
    public final static int OBLIQUE_VALUE = 14; // 斜移动代价

    /**
     * 2) 定义两个辅助表：Open表和Close表。Open表的使用是需要取最小值，在这里我们使用Java工具包中的优先队列PriorityQueue，Close只是用来保存结点，没其他特殊用途，就用ArrayList。
     */
    Queue<Node> openList = new PriorityQueue<Node>(); // 优先队列(升序)
    List<Node> closeList = new ArrayList<Node>();

    /**
     * 开始算法
     * (8) 开始算法，循环移动结点寻找路径，设定循环结束条件，Open表为空或者最终结点在Close表
     */
    public void start(MapInfo mapInfo) {
        if (mapInfo == null) return;
        // clean
        openList.clear();
        closeList.clear();
        // 开始搜索
        openList.add(mapInfo.start);
        moveNodes(mapInfo);
    }

    /**
     * 移动当前结点
     */
    private void moveNodes(MapInfo mapInfo) {
        while (!openList.isEmpty()) {
            Node current = openList.poll();
            closeList.add(current);
            addNeighborNodeInOpen(mapInfo, current);
            if (isCoordInClose(mapInfo.end.coord)) {
                drawPath(mapInfo.maps, mapInfo.end);
                break;
            }
        }
    }

    /**
     * 在二维数组中绘制路径
     * 回溯法绘制路径
     */
    private void drawPath(int[][] maps, Node end) {
        if (end == null || maps == null) return;
        System.out.println("总代价：" + end.G);
        while (end != null) {
            Coord c = end.coord;
            maps[c.y][c.x] = PATH;
            end = end.parent;
        }
    }

    /**
     * 添加所有邻结点到open表
     * (6) 添加邻结点到Open表
     */
    private void addNeighborNodeInOpen(MapInfo mapInfo, Node current) {
        int x = current.coord.x;
        int y = current.coord.y;
        // 左
        addNeighborNodeInOpen(mapInfo, current, x - 1, y, DIRECT_VALUE);
        // 上
        addNeighborNodeInOpen(mapInfo, current, x, y - 1, DIRECT_VALUE);
        // 右
        addNeighborNodeInOpen(mapInfo, current, x + 1, y, DIRECT_VALUE);
        // 下
        addNeighborNodeInOpen(mapInfo, current, x, y + 1, DIRECT_VALUE);
        // 左上
        addNeighborNodeInOpen(mapInfo, current, x - 1, y - 1, OBLIQUE_VALUE);
        // 右上
        addNeighborNodeInOpen(mapInfo, current, x + 1, y - 1, OBLIQUE_VALUE);
        // 右下
        addNeighborNodeInOpen(mapInfo, current, x + 1, y + 1, OBLIQUE_VALUE);
        // 左下
        addNeighborNodeInOpen(mapInfo, current, x - 1, y + 1, OBLIQUE_VALUE);
    }

    /**
     * 添加一个邻结点到open表
     */
    private void addNeighborNodeInOpen(MapInfo mapInfo, Node current, int x, int y, int value) {
        if (canAddNodeToOpen(mapInfo, x, y)) {
            Node end = mapInfo.end;
            Coord coord = new Coord(x, y);
            int G = current.G + value; // 计算邻结点的G值
            Node child = findNodeInOpen(coord);
            if (child == null) {
                int H = calcH(end.coord, coord); // 计算H值
                if (isEndNode(end.coord, coord)) {
                    child = end;
                    child.parent = current;
                    child.G = G;
                    child.H = H;
                } else {
                    child = new Node(coord, current, G, H);
                }
                openList.add(child);
            } else if (child.G > G) {
                child.G = G;
                child.parent = current;
                openList.add(child);
            }
        }
    }

    /**
     * 从Open列表中查找结点
     * (5) 从Open列表中查找结点
     */
    private Node findNodeInOpen(Coord coord) {
        if (coord == null || openList.isEmpty()) return null;
        for (Node node : openList) {
            if (node.coord.equals(coord)) {
                return node;
            }
        }
        return null;
    }


    /**
     * 计算H的估值：“曼哈顿”法，坐标分别取差值相加
     * (4) 计算H值，“曼哈顿” 法，坐标分别取差值相加
     */
    private int calcH(Coord end, Coord coord) {
        return Math.abs(end.x - coord.x)
                + Math.abs(end.y - coord.y);
    }

    /**
     * 判断结点是否是最终结点
     * <p>
     * (3) 定义几个布尔判断方法：最终结点的判断、结点能否加入open表的判断、结点是否在Close表中的判断。
     */
    private boolean isEndNode(Coord end, Coord coord) {
        return coord != null && end.equals(coord);
    }

    /**
     * 判断结点能否放入Open列表
     */
    private boolean canAddNodeToOpen(MapInfo mapInfo, int x, int y) {
        // 是否在地图中
        if (x < 0 || x >= mapInfo.width || y < 0 || y >= mapInfo.high) return false;
        // 判断是否是不可通过的结点
        if (mapInfo.maps[y][x] == BAR) return false;
        // 判断结点是否存在close表
        if (isCoordInClose(x, y)) return false;

        return true;
    }

    /**
     * 判断坐标是否在close表中
     */
    private boolean isCoordInClose(Coord coord) {
        return coord != null && isCoordInClose(coord.x, coord.y);
    }

    /**
     * 判断坐标是否在close表中
     */
    private boolean isCoordInClose(int x, int y) {
        if (closeList.isEmpty()) return false;
        for (Node node : closeList) {
            if (node.coord.x == x && node.coord.y == y) {
                return true;
            }
        }
        return false;
    }
}
