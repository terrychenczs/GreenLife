package com.czs.util.jsonUtil.Entity;

import com.czs.util.jsonUtil.Entity.AbstractJSON;

/*
 * 建立JSON对象类SingleObject
 */
public class SingleObject extends AbstractJSON {
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}