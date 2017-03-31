package com.example.kukey.diytest;


import com.example.kukey.diytest.config.AppConfig;
import com.example.kukey.diytest.util.CrashHandler;
import com.example.kukey.diytest.util.Logger;

/**
 * @author EX-CHENWEIBIN001
 *
 */
public class Application extends android.app.Application{
	
	private static Application _instance;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		_instance = this;
	    Logger.setTag("diyview_debugLog");
	    Logger.setDebug(true);// 开始NoHttp的调试模式, 这样就能看到请求过程和日志
	    CrashHandler crashHandler = CrashHandler.getInstance();
	    crashHandler.init(this);  
	    AppConfig.getInstance();
	}
	
	public static Application getInstance(){
		return _instance;
	}
	
	
}
