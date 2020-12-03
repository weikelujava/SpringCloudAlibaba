package com.smart.algorithm.trietree;


import java.util.Arrays;
import java.util.List;

/**
 *
 * @version V1.0
 * @title: Test
 * @description: 测试
 * @author: lukewei
 * @date: 2020-12-02 15:06
 * @remark: 修改内容
 */
public class Test {


    public static void main(String[] args) {

        TrieUtil trieUtil = TrieUtil.getInstance("D:\\workspace\\SpringCloudAlibaba\\spring-cloud-alibaba\\c-algorithm\\src\\main\\resources\\sensitivewords.txt");

//        String test = "卧槽真的很不错";

        List<String> list = Arrays.asList("卧槽真的很不错","尼玛不是人啊,fuck u ","马老师救救我");
//        List<String> list = Arrays.asList("尼玛不是人啊,fuck u ");
        for (String str : list) {

            List<String> sensitiveWords = trieUtil.getContainsItem2(str);

          if(null != sensitiveWords && !sensitiveWords.isEmpty()){
              for (String sensitiveWord : sensitiveWords) {
                  String replace = "";
                  for (int i = 0; i < sensitiveWord.length(); i++) {
                      replace += "*";
                  }
                 str = str.replace(trieUtil.getContainsItem(str), replace);
              }
          }
            System.out.println(str);
        }

    }
}
