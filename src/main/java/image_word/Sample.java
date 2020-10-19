package image_word;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import com.baidu.aip.ocr.AipOcr;

public class Sample{
	// 设置APPID/AK/SK
	public static final String APP_ID = "22837338";
	public static final String API_KEY = "TgyRs7SZM6ggCZa5cNRwYaLG";
	public static final String SECRET_KEY = "6hpvkneWeb8xn9lIWNEIjhIIXmcRz2cn";

	// 初始化用户对象
    public static AipOcr init() {
    	// 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        
        return client;
	}

    public void sample() {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

        AipOcr client = init();
        
        // 参数为本地图片路径  路径必须为绝对路径
        String path = "D:\\IDEA_javaWeb\\infoextr\\src\\main\\resources\\image_word\\12.jpg";
        JSONObject res = client.basicAccurateGeneral(path, options);

        // 调试
      // System.out.println(res.toString(2));
        //System.out.println(res.get("words_result"));

        // 获得识别的结果
        JSONArray mylist = (JSONArray) res.get("words_result");
        for (int i = 0; i < mylist.length(); i++) {
            JSONObject object = (JSONObject) mylist.get(i);
            System.out.println(object.get("words"));;
        }


//        // 参数为本地图片二进制数组
//        byte[] file = readImageFile(image);
//        res = client.basicGeneral(file, options);
//        System.out.println(res.toString(2));


        // 通用文字识别, 图片参数为远程url图片
//        JSONObject res = client.basicGeneralUrl(url, options);
//        System.out.println(res.toString(2));

    }

    public static void main(String[] args) {
        new Sample().sample();
    }
}
