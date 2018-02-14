/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atvanta.util;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Levi
 */
public class CoreQuery {
   
    private String queryString;
    private int startFrom;
    private int maxCount;
    private List<CoreQueryParam> queryParams;
    private boolean isLazyLoad;

    public CoreQuery(String queryString, List<CoreQueryParam> queryParams) {
        this.queryString = queryString;
        this.queryParams = queryParams;
        this.startFrom = -1;
        this.maxCount = -1;
        this.isLazyLoad = false;
    }

    public CoreQuery(String queryString) {
        this.queryString = queryString;
        this.queryParams = new ArrayList<>();
        this.startFrom = -1;
        this.maxCount = -1;
        this.isLazyLoad = false;
    }

    public CoreQuery(String queryString, String paramName, Object paramValue) {
        this.queryString = queryString;
        this.queryParams = new ArrayList<>();
        this.addParam(paramName, paramValue);
        this.startFrom = -1;
        this.maxCount = -1;
        this.isLazyLoad = false;
    }

    public CoreQuery(String queryString, String paramName, Object paramValue, int maxCount) {
        this.queryString = queryString;
        this.queryParams = new ArrayList<>();
        this.addParam(paramName, paramValue);
        this.startFrom = -1;
        this.maxCount = maxCount;
        this.isLazyLoad = false;
    }

    public CoreQuery(String queryString, String paramName, Object paramValue, int startFrom, int maxCount) {
        this.queryString = queryString;
        this.queryParams = new ArrayList<>();
        this.addParam(paramName, paramValue);
        this.startFrom = startFrom;
        this.maxCount = maxCount;
        this.isLazyLoad = false;
    }

    public CoreQuery(String queryString, int startFrom, int maxCount, List<CoreQueryParam> queryParams) {
        this.queryString = queryString;
        this.startFrom = startFrom;
        this.maxCount = maxCount;
        this.queryParams = queryParams;
        this.isLazyLoad = false;
    }

    public CoreQuery(String queryString, int maxCount, List<CoreQueryParam> queryParams) {
        this.queryString = queryString;
        this.maxCount = maxCount;
        this.startFrom = -1;
        this.queryParams = queryParams;
        this.isLazyLoad = false;
    }

    public CoreQuery(String queryString, int startFrom, int maxCount) {
        this.queryString = queryString;
        this.startFrom = startFrom;
        this.maxCount = maxCount;
        this.queryParams = new ArrayList<>();
        this.isLazyLoad = false;
    }

    public CoreQuery(String queryString, int maxCount) {
        this.queryString = queryString;
        this.startFrom = -1;
        this.maxCount = maxCount;
        this.queryParams = new ArrayList<>();
        this.isLazyLoad = false;
    }

    public CoreQuery(String queryString, List<CoreQueryParam> queryParams, boolean isLazyLoad) {
        this.queryString = queryString;
        this.queryParams = queryParams;
        this.startFrom = -1;
        this.maxCount = -1;
        this.isLazyLoad = isLazyLoad;
    }

    public CoreQuery(String queryString, boolean isLazyLoad) {
        this.queryString = queryString;
        this.queryParams = new ArrayList<>();
        this.startFrom = -1;
        this.maxCount = -1;
        this.isLazyLoad = isLazyLoad;
    }

    public CoreQuery(String queryString, String paramName, Object paramValue, boolean isLazyLoad) {
        this.queryString = queryString;
        this.queryParams = new ArrayList<>();
        this.addParam(paramName, paramValue);
        this.startFrom = -1;
        this.maxCount = -1;
        this.isLazyLoad = isLazyLoad;
    }

    public CoreQuery(String queryString, String paramName, Object paramValue, int startFrom, int maxCount, boolean isLazyLoad) {
        this.queryString = queryString;
        this.queryParams = new ArrayList<>();
        this.addParam(paramName, paramValue);
        this.startFrom = startFrom;
        this.maxCount = maxCount;
        this.isLazyLoad = isLazyLoad;
    }

    public CoreQuery(String queryString, int startFrom, int maxCount, List<CoreQueryParam> queryParams, boolean isLazyLoad) {
        this.queryString = queryString;
        this.startFrom = startFrom;
        this.maxCount = maxCount;
        this.queryParams = queryParams;
        this.isLazyLoad = isLazyLoad;
    }

    public CoreQuery(String queryString, int maxCount, List<CoreQueryParam> queryParams, boolean isLazyLoad) {
        this.queryString = queryString;
        this.maxCount = maxCount;
        this.startFrom = -1;
        this.queryParams = queryParams;
        this.isLazyLoad = isLazyLoad;
    }

    public CoreQuery(String queryString, int startFrom, int maxCount, boolean isLazyLoad) {
        this.queryString = queryString;
        this.startFrom = startFrom;
        this.maxCount = maxCount;
        this.queryParams = new ArrayList<>();
        this.isLazyLoad = isLazyLoad;
    }

    public void addParam(String paramName, Object paramValue) {
        this.queryParams.add(new CoreQueryParam(paramName, paramValue));
    }

    public void addParam(CoreQueryParam param) {
        this.queryParams.add(param);
    }

    public String getQueryString() {
        return queryString;
    }

    public int getStartFrom() {
        return startFrom;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public List<CoreQueryParam> getQueryParams() {
        return queryParams;
    }

    public boolean isLazyLoad() {

        return isLazyLoad;
    }

    public void setLazyLoad(boolean isLazyLoad) {
        this.isLazyLoad = isLazyLoad;
    } 
}
