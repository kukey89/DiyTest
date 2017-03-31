package com.example.kukey.diytest.net;



import com.example.kukey.diytest.bean.HealthClassifyBean;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;


public interface LocalApi {

    //获取类别
    @GET("classify")
    Observable<List<HealthClassifyBean>> getHealthClassify();


}
