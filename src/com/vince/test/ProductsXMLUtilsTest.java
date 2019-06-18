package com.vince.test;

import com.vince.bean.Clothes;
import com.vince.utils.ProductsXmlUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author liuxingxing
 * @date 2019-06-18 13:56
 */
public class ProductsXMLUtilsTest {
    @Test
    public void test(){
        List<Clothes> clothes = ProductsXmlUtils.parserProductFromXml();
        System.out.println(Arrays.toString(clothes.toArray()));
    }
}
