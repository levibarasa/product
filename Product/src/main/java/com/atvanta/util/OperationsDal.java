/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atvanta.util;

import java.util.List;
/**
 *
 * @author Levi
 */
public interface OperationsDal {
    boolean saveOrUpdate(Object object);

    Object save(Object object);

    boolean delete(Object object);

    void executeQuery(CoreQuery query);

    List fetch(CoreQuery query);

    int getRecordCount(CoreQuery query); 
}
