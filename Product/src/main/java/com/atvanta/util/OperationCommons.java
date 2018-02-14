/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atvanta.util;

import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;
/**
 *
 * @author Levi
 */
public class OperationCommons {
   public static Query getSessionQuery(CoreQuery query, Session session) {
        Query sessionQuery = session.createQuery(query.getQueryString());

        if (query.getStartFrom() >= 0 && query.getMaxCount() >= 0) {
            sessionQuery.setFirstResult(query.getStartFrom()).setMaxResults(query.getMaxCount());
        } else if (query.getStartFrom() < 0 && query.getMaxCount() >= 0) {
            sessionQuery.setMaxResults(query.getMaxCount());
        } else if (query.getStartFrom() >= 0 && query.getMaxCount() < 0) {
            sessionQuery.setFirstResult(query.getStartFrom());
        }
        if (Validator.validateList(query.getQueryParams())) {
            for (CoreQueryParam param : query.getQueryParams()) {
                if (param.getParamValue() instanceof List) {
                    sessionQuery.setParameterList(param.getParamName(), (List) param.getParamValue());
                } else {
                    sessionQuery.setParameter(param.getParamName(), param.getParamValue());
                }
            }
        }
        return sessionQuery;
    }  
}
