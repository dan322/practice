package hello.collection.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bysocket on 16/9/26.
 */
public class HashList {
    public static void main(String[] args) {
        // init data list
       /* List reqSkuObjList = new ArrayList<SkuObj>();
        List existSkuObjList = new ArrayList<SkuObj>();*/

      /*  List<SkuObj> reqSkuObjList = new ArrayList();
        List<SkuObj> existSkuObjList = new ArrayList();*/

        List<SkuObj> reqSkuObjList = new ArrayList<SkuObj>();
        List<SkuObj> existSkuObjList = new ArrayList<SkuObj>();
        for (int i = 0 ; i < 5000; i++) {
            SkuObj skuObj = new SkuObj();
            skuObj.setId(i);
            skuObj.setName("name" + i);
            skuObj.setAge(i + 666);
            skuObj.setDesc("desc" + i);
            reqSkuObjList.add(skuObj);
        }

        for (int i = 0 ; i < 5000; i++) {
            SkuObj skuObj = new SkuObj();
            skuObj.setId(i);
            skuObj.setName("nameexist" + i);
            skuObj.setAge(i + 888);
            skuObj.setDesc("descexist" + i);
            existSkuObjList.add(skuObj);
        }



    }
}