package com.srs.java.javabase.easyexcel.code;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author shaorensheng
 * @date 2021/9/17
 */
public class MyLinstener extends AnalysisEventListener<LinkedHashMap> {

    List<List<String>> datas = new ArrayList<>();

    @Override
    public void invoke(LinkedHashMap map, AnalysisContext context) {
        List<String> data = new ArrayList<>();
        Iterator iterator = map.values().iterator();
        while (iterator.hasNext()) {
            data.add((String) iterator.next());
        }
        datas.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //可以在此处统一处理读取的数据，比如save
    }

    public List<List<String>> getDatas() {
        return datas;
    }

    public void setDatas(List<List<String>> datas) {
        this.datas = datas;
    }
}
