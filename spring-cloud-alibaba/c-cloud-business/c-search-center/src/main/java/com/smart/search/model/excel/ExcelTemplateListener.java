package com.smart.search.model.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.smart.search.service.ExcelUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模板的读取类
 *
 * @author lukewei
 */
// 有个很重要的点 ExcelTemplateListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
@Slf4j
public class ExcelTemplateListener extends AnalysisEventListener<ExcelData> {


    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<String> list = new ArrayList<>();
    List<ExcelData> dataList = new ArrayList<ExcelData>();


    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private ExcelUploadService excelUploadService;

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public ExcelTemplateListener(ExcelUploadService excelUploadService) {
        this.excelUploadService = excelUploadService;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
//    @Override
//    public void invoke(ExcelTemplate data, AnalysisContext context) {
//        log.info("解析到一条数据:{}", JSON.toJSONString(data));
//        list.add(data);
//        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
//        if (list.size() >= BATCH_COUNT) {
//            saveData();
//            // 存储完成清理 list
//            list.clear();
//        }
//    }
    @Override
    public void invoke(ExcelData data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        dataList.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (dataList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            dataList.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", dataList.size());
        AtomicInteger count = new AtomicInteger(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
        for (ExcelData excelData : dataList) {

            count.getAndIncrement();
            list.add(excelData.getSensitiveName());
        }
        excelUploadService.saveExcelDateToRedis(list);
        list.clear();
        log.info("存储数据库成功！");
    }


}
