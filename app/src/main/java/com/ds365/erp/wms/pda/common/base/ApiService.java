package com.ds365.erp.wms.pda.common.base;

import com.ds365.erp.wms.pda.model.user.VerifyCodeModel;
import com.ds365.networkconnections.http.Url;
import com.ds365.networkconnections.model.HttpResult;

import retrofit2.http.GET;
import rx.Observable;

public interface ApiService {
   /* @GET("/student/mobileRegister")
    Observable<HttpResult<UserEntity>> login(@Query("phone") String phone, @Query("password") String psw);


    @GET("top250")
    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);

    @GET("top250")
    Observable<HttpResult<Subject>> getUser( @Query("touken") String touken);*/

    @GET("/erp-mobile-commons-web-main/commons/captchaCode/getCaptchaToken")
    Observable<HttpResult<VerifyCodeModel>> getImage();

//    getCommonIP() + "commons/captchaCode/getCaptchaImage";

//    Observable



}
