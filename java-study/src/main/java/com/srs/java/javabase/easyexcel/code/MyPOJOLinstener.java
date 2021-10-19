package com.srs.java.javabase.easyexcel.code;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.srs.java.javabase.easyexcel.code.vo.UserVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaorensheng
 * @date 2021/9/17
 */
public class MyPOJOLinstener extends AnalysisEventListener<UserVo> {

    List<UserVo> datas = new ArrayList<>();

    @Override
    public void invoke(UserVo vo, AnalysisContext context) {
        datas.add(vo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //可以在此处统一处理读取的数据，比如save
    }

    public List<UserVo> getDatas() {
        return datas;
    }

    public void setDatas(List<UserVo> datas) {
        this.datas = datas;
    }
}
