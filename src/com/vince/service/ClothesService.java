package com.vince.service;

import com.vince.bean.Clothes;
import com.vince.utils.BussinessException;

import java.util.List;

public interface ClothesService {
    public List<Clothes> list() throws BussinessException;
}
