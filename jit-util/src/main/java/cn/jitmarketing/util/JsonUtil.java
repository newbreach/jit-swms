package cn.jitmarketing.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/4/15.
 */
public class JsonUtil {

    /**
     * 将json转化为实体POJO
     */
    public static <T> Object JSONToObj(String jsonStr, Class<T> obj) {
        T t = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            t = objectMapper.readValue(jsonStr,
                    obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 将实体POJO转化为JSON
     */
    public static <T> JSONObject objectToJson(T obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw e;
        }
        return new JSONObject(jsonStr);
    }


    /**
     * 将实体POJO转化为String
     */
    public static String objectToStr(Object obj) throws Exception {
        String str = null;
        try {
            JSONObject jsonObject = objectToJson(obj);
            str = jsonObject.toString();
        } catch (Exception e) {

        }
        return str;
    }




}
