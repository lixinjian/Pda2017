package com.ds365.networkconnections.http;

import com.ds365.networkconnections.model.HttpResult;
import com.ds365.networkconnections.model.VerifyCodeModel;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by helin on 2016/10/9 17:09.
 */

public interface ApiService {
   /* @GET("/student/mobileRegister")
    Observable<HttpResult<UserEntity>> login(@Query("phone") String phone, @Query("password") String psw);


    @GET("top250")
    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);

    @GET("top250")
    Observable<HttpResult<Subject>> getUser( @Query("touken") String touken);*/

    @GET("/erp-mobile-commons-web-main/commons/captchaCode/getCaptchaToken")
    Observable<HttpResult<VerifyCodeModel>> getImage();

}
