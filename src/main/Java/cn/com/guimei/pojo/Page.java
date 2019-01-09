package cn.com.guimei.pojo;

import java.util.List;

public class Page<T> {
    private int pageSize;//每页显示的条数
    private int pageNumber;//当前是第几页
    private int totalPage;//总的页数
    private int totalRecord;//总条数
    private List<T> pageData;//页面数据
    private String servletURL;//控制层给视图层传的地址,主要是用于页面抽取

    public void getPages(){
        totalPage = totalRecord%pageSize==0?totalRecord/pageSize:totalRecord/pageSize+1;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalPage() {
        getPages();
        return totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public String getServletURL() {
        return servletURL;
    }

    public void setServletURL(String servletURL) {
        this.servletURL = servletURL;
    }
}
