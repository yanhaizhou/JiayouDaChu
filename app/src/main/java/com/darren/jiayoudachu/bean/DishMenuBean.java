package com.darren.jiayoudachu.bean;

import android.util.Log;


import java.util.List;

/**
 * Created by Darren on 17/4/1.
 *
 */

public class DishMenuBean {
    private String mDishName;
    private List mMaterialList;

    public DishMenuBean(String dishName, List materialList){
        if (materialList == null || dishName == null)
            Log.e(getClass().getSimpleName(), "It could not be null in DishMenuBean.");
        mMaterialList =  materialList;
        mDishName = dishName;
    }

    public String getmDishName() {
        return mDishName;
    }

    public void setmDishName(String mDishName) {
        this.mDishName = mDishName;
    }

    public List getmMaterialList() {
        return mMaterialList;
    }

    public void setmMaterialList(List mMaterialList) {
        this.mMaterialList = mMaterialList;
    }
}
