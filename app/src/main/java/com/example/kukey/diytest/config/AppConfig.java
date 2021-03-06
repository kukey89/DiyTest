/*
 * Copyright © YOLANDA. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.kukey.diytest.config;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;


import com.example.kukey.diytest.Application;
import com.example.kukey.diytest.util.FileUtil;

import java.io.File;
import java.util.Set;

/**
 * @author EX-CHENWEIBIN001
 *
 */
public class AppConfig {

    private static AppConfig appConfig;

    private SharedPreferences preferences;

    public static final boolean DEBUG = true;

    public String APP_PATH_ROOT;

    private AppConfig() {
        preferences = Application.getInstance().getSharedPreferences("diyview", Context.MODE_PRIVATE);
        APP_PATH_ROOT = FileUtil.getRootPath().getAbsolutePath() + File.separator + "sharePreferencesFile";
        FileUtil.initDirectory(APP_PATH_ROOT);
    }

    public static AppConfig getInstance() {
        if (appConfig == null)
            appConfig = new AppConfig();
        return appConfig;
    }

    public void putInt(String key, int value) {
        preferences.edit().putInt(key, value).commit();
    }

    public int getInt(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }

    public void putString(String key, String value) {
        preferences.edit().putString(key, value).commit();
    }

    public String getString(String key, String defValue) {
        return preferences.getString(key, defValue);
    }

    public void putBoolean(String key, boolean value) {
        preferences.edit().putBoolean(key, value).commit();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }

    public void putLong(String key, long value) {
        preferences.edit().putLong(key, value).commit();
    }

    public long getLong(String key, long defValue) {
        return preferences.getLong(key, defValue);
    }

    public void putFloat(String key, float value) {
        preferences.edit().putFloat(key, value).commit();
    }

    public float getFloat(String key, float defValue) {
        return preferences.getFloat(key, defValue);
    }

    @SuppressLint("NewApi")
	public void putStringSet(String key, Set<String> value) {
        preferences.edit().putStringSet(key, value).commit();
    }

    @SuppressLint("NewApi")
	public Set<String> getStringSet(String key, Set<String> defValue) {
        return preferences.getStringSet(key, defValue);
    }

}
