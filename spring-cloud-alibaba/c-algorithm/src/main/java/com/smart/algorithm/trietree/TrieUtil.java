package com.smart.algorithm.trietree;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @version V1.0
 * @title: TrieTreeDemo
 * @description:  字典树算法
 *  说明: 字典树，又称单词查找树,是一种树形结构，是一种哈希树的变种
 *  用途：用于统计和排序大量的字符串，经常呗搜索引擎系统用于文本词频的统计
 *  优点：最大限度的减少无谓的字符串比较
 *  核心思想：空间换时间，利用字符串的公共前缀来降低查询的时间的开销以达到提高效率的目的。
 *
 *  三个基本特性：
 *  1.根节点不包含字符，除根节点外的每一个节点都包含一个字符
 *  2.从根节点到某一节点，路径上经过的字符串链接起来，为该节点对应的字符串
 *  3.每个节点的所有子节点包含的字符都不相同
 *
 * @author: lukewei
 * @date: 2020-12-02 13:33
 * @remark: 修改内容
 */
public class TrieUtil {

    /**
     * Trie工具类
     */
    private static TrieUtil instance;

    /**
     * Trie树的根节点
     */
    private static TrieNode root;


    /**
     * 将Resource目录下的 sensitivewords文件中的敏感词并加入到root树中
     *
     * 这块，可以优化成管理者可以录入敏感词，并将敏感词存放到该根节点下
     * 参考 使用Redis 的List数据结构存储，健使用词的hashcode处理，值存放的敏感词
     * 同时监听敏感词库的变化，并更新前缀树的节点数据
     *
     * @param siteNamePath  文件路径
     */
    private TrieUtil(String siteNamePath) {
        root = new TrieNode();
        try {
            Files.lines(Paths.get(siteNamePath)).forEach(TrieUtil::addWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static TrieUtil getInstance(String siteNamePath) {
        if (instance == null) {
            synchronized (TrieUtil.class) {
                if (instance == null) {
                    instance = new TrieUtil(siteNamePath);
                }
            }
        }
        return instance;
    }

    /**
     * 前缀树 增加增加节点
     * @param word  敏感词
     */
    public static void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        // 每次调用addWord都重新拿到全局根节点对象
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char code = word.charAt(i);
            // 增加字母, 并且返回子节点继续增加
            current = current.add(code);
        }
        current.end = true;
    }

    /**
     * 一个节点对象
     * value： 当前节点存储的字母
     * child： 当前节点的子节点信息 字母 -> 节点对象
     * end: 是否是整个词的结尾
     */
    private static class TrieNode {
        public char value;
        public Map<Character, TrieNode> child = new HashMap<>();
        private boolean end = false;

        public TrieNode() {
        }

        public TrieNode add(char newChar) {
            if (child == null) {
                this.child = new HashMap<>();
            }
            // 找到对应字符的字典树
            TrieNode t = child.get(newChar);
            // 在map中查找是否已经存在字母
            if (t == null) {
                // 不存在则新建一个节点对象
                t = new TrieNode();
                // 给节点对象命名为该字母
                t.value = newChar;
                child.put(newChar, t);
            }
            // 返回下一个节点
            return t;
        }
    }

    /**
     * 判断输入的文本信息是否包含敏感词
     * @param text 用户数输入的文本数据
     * @return
     */
    public boolean isContains(String text) {
        if (text == null || text.length() == 0) {
            return false;
        }
        // 获得前缀树
        TrieNode current = root;
        // 从词的首位开始遍历
        int index = 0;
        while (index < text.length()) {
            // 如果在当前层找到当前字母，继续往下一层找
            if (current.child.get(text.charAt(index)) != null) {
                current = current.child.get(text.charAt(index));
            } else {
                // 如果在当前这一层找不到字符子节点，直接切到新的root该子节点下重新找
                // 如果root下也没有该字母，继续返回root给下一个字母调用防止空指针
                current = (root.child.get(text.charAt(index)) == null) ? root : root.child.get(text.charAt(index));
            }
            // 判断是否存在的依据： 当前查找返回的节点对象是否是end标志
            if (current.end) {
                return true;
            }
            index += 1;
        }
        return false;
    }


    /**
     * 获取用户输入的敏感词
     *
     *
     * @param text 用户输入的文本数据
     * @return
     */
    public String getContainsItem(String text) {
        if (text == null || text.length() == 0) {
            return null;
        }
        TrieNode current = root;
        int index = 0;
        int startIndex = 0;
        int endIndex = 0;
        while (index < text.length()) {
            if (current.child.get(text.charAt(index)) != null) {
                current = current.child.get(text.charAt(index));
            } else {
                // startIndexstartIndex在else条件中更新
                // 有两种情况，如果在根节点都找不到当前字则从index+1开始，如果根节点存在该字，从index开始
                if (root.child.get(text.charAt(index)) == null) {
                    current = root;
                    startIndex = index + 1;
                } else {
                    current = root.child.get(text.charAt(index));
                    startIndex = index;
                }
            }
            if (current.end) {
                endIndex = index;
                return text.substring(startIndex, endIndex + 1);
            }
            index += 1;
        }
        return null;
    }

    /**
     * 文本数据包含多个敏感词
     *
     * @param text 用户输入的敏感词
     * @return 敏感词列表
     */
    public List<String> getContainsItem2(String text) {
        List<String> res = new ArrayList<>();
        if (text == null || text.length() == 0) {
            return res;
        }
        TrieNode current = root;
        int index = 0;
        int startIndex = 0;
        int endIndex = 0;
        while (index < text.length()) {
            if (current.child.get(text.charAt(index)) != null) {
                current = current.child.get(text.charAt(index));
            } else {
                // startIndexstartIndex在else条件中更新
                // 有两种情况，如果在根节点都找不到当前字则从index+1开始，如果根节点存在该字，从index开始
                if (root.child.get(text.charAt(index)) == null) {
                    current = root;
                    startIndex = index + 1;
                } else {
                    current = root.child.get(text.charAt(index));
                    startIndex = index;
                }
            }
            if (current.end) {
                endIndex = index;
                res.add(text.substring(startIndex, endIndex + 1));
                // 重置为root
                current = root;
                // 重置startIndex
                startIndex = endIndex + 1;

            }
            index += 1;
        }
        return res;
    }
}
