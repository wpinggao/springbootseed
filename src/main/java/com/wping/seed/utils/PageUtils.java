package com.wping.seed.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wping.seed.vo.PagedResult;

import java.util.List;

/**
 * 响应结果生成工具
 */
public class PageUtils {

    // 设置分页
    public static void setStartPage(Integer pageNo, Integer pageSize) {
        if (pageNo != null && pageNo > 0 && pageSize != null && pageSize > 0) {
            //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
            PageHelper.startPage(pageNo, pageSize);
        }
    }

    public static <T> PagedResult<T> toPagedResult(List<T> datas) {
        PagedResult<T> result = new PagedResult<T>();
        if (datas instanceof Page) {
            Page page = (Page) datas;
            result.setPageNo(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setDataList(page.getResult());
            result.setTotal(page.getTotal());
            result.setPages(page.getPages());
        } else {
            result.setPageNo(1);
            result.setPageSize(datas.size());
            result.setDataList(datas);
            result.setTotal(datas.size());
            result.setPages(datas.size() > 0 ? 1 : 0);
        }
        return result;
    }
}
