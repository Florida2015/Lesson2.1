package cn.edu.nuc.lesson2;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

import java.util.List;

/**
 * Created by Flming2015 on 2015/12/29.
 */
public interface QsbkService {
    @GET("article/list/{type}")
    Call<Response> getList(@Path("type")String type,@Query("page")int page);
}

//GET 的请求的参数使用@Query
