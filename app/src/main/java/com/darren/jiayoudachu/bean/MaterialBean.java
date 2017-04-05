package com.darren.jiayoudachu.bean;

import android.util.Log;

import com.darren.jiayoudachu.config.Constants;
import com.darren.jiayoudachu.utils.UserDefinedExceptions;

/**
 * Created by Darren on 17/3/31.
 * 材料
 */
public class MaterialBean {

    public MaterialBean(short type, String name, int num) {
        this.type = type;
        this.num = num;
        this.name = name;
    }

    /**
     * 材料名
     */
    private String name;
    /**
     * 材料类型
     */
    private short type;

    /**
     * 材料数量，默认单位为g，-1表示适量。-2表示两倍适量，以此类推。
     */
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) throws UserDefinedExceptions {
        if (num == 0)
            Log.e(getClass().getSimpleName(),
                    "Error occurs when setting Num in MaterialBean:It is wrong num!");
        this.num = num;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) throws UserDefinedExceptions {
        if (type == Constants.MaterialType.CONDIMENT
                || type == Constants.MaterialType.GREENS
                || type == Constants.MaterialType.MEAT)
            this.type = type;
        else Log.e(getClass().getSimpleName(),
                "Error occurs when setting Type in MaterialBean:It is wrong type!");

    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        if (null == name)
            Log.e(getClass().getSimpleName(),
                    "Error occurs when setting Name in MaterialBean:The name could not be null!");
        this.name = name;
    }
}
