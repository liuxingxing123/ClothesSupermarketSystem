package com.vince.utils;

import com.vince.bean.Clothes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxingxing
 * @date 2019-06-18 19:38
 */
public class ClothesIO {

    private static List<Clothes> list = new ArrayList<>();

    public Clothes findById(String cid) throws BussinessException{
        for(Clothes c:list){
            if(c.getId().equals(cid)){
                return  c;
            }
        }
        return null;
    }

    public List<Clothes> list() throws BussinessException{
        if(list.size()==0){
            list = ProductsXmlUtils.parserProductFromXml();
        }
         return list;
    }
    //更新xml文件
    public void update() throws BussinessException{
        ProductsXmlUtils.writeProductToXml(list);
    }
}
