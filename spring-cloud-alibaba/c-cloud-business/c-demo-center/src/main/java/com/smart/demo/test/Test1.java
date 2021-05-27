package com.smart.demo.test;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lukewei
 * @date 2021/5/11 12:00
 */
@Slf4j
public class Test1 {
    public static void main(String[] args) throws ParseException {

        int a = 5;
        int total = 5;

        total+=a;
        System.out.println("total:"+total);






        String s1 = "2021-05-11 10:10:10";
        String e1 = "1022-01-10 10:10:10";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date saleStartDate = format.parse(s1);
        Date saleEndDate = format.parse(e1);
//        Date nowDate = new Date();
//        long nowTime = nowDate.getTime();

//        boolean saleStartTime;
//        if(null != saleStartDate){
//            long saleStartDateTime = saleStartDate.getTime();
//            saleStartTime = nowTime >= saleStartDateTime;
//        }else {
//            saleStartTime = true;
//        }
//
//        boolean saleEndTime;
//        if(null != saleEndDate){
//            long saleEndDateTime = saleEndDate.getTime();
//            saleEndTime= nowTime <= saleEndDateTime;
//        }else {
//            saleEndTime = true;
//        }
//        if( !saleStartTime || !saleEndTime){
//           log.info("start:{},end:{}",saleStartTime,saleEndTime);
//        }
//
//        System.out.println("star:"+saleStartTime);
//        System.out.println("end:"+saleEndTime);

        boolean flag = currentTimeInSaleStartTimeAndSaleEndTime(saleStartDate, saleEndDate);
        System.out.println("------:"+flag);

    }


    /**
     *
     * @param startDate   开始时间
     * @param endDate   结束时间
     * @return   true在时间段内，false不在时间段内
     */
    private static boolean currentTimeInSaleStartTimeAndSaleEndTime(Date startDate,Date endDate){

        Date nowDate = new Date();
        long nowTime = nowDate.getTime();
        // 开始时间
        boolean saleStartTime;
        if(null != startDate){
            long saleStartDateTime = startDate.getTime();
            saleStartTime = nowTime >= saleStartDateTime;
        }else {
            saleStartTime = true;
        }
        // 结束时间
        boolean saleEndTime;
        if(null != endDate){
            long saleEndDateTime = endDate.getTime();
            saleEndTime= nowTime <= saleEndDateTime;
        }else {
            saleEndTime = true;
        }

        return (saleStartTime && saleEndTime);
    }
}
