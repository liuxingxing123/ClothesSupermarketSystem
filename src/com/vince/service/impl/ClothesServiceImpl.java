package com.vince.service.impl;

import com.vince.bean.Clothes;
import com.vince.service.ClothesService;
import com.vince.utils.BussinessException;
import com.vince.utils.ClothesIO;
import com.vince.utils.ProductsXmlUtils;

import java.util.List;

/**
 * @author liuxingxing
 * @date 2019-06-18 14:15
 */
public class ClothesServiceImpl implements ClothesService {
    private ClothesIO clothesIO = new ClothesIO();
    @Override
    public List<Clothes> list() throws BussinessException {
        return clothesIO.list();
    }

    @Override
    public Clothes findById(String cid) throws BussinessException {
        return clothesIO.findById(cid);
    }

    public void update() throws  BussinessException{
        clothesIO.update();
    }
}
