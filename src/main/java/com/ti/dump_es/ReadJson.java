package com.ti.dump_es;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadJson {
    public String readJson(String path) {
        try {
            File file = new File(path);
            if (file.exists()) {
                String json_str = FileUtils.readFileToString(file, "UTF-8");
                JSONObject jsonObject = new JSONObject(json_str);
                jsonObject.remove("id");
                System.out.println(jsonObject.toString());
                return jsonObject.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public List<String> readStixDirectory(String directory) {
        File file = new File(directory);
        List<String> result = new ArrayList<>();
        if (file.exists()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                String name = f.getName();
                if (!f.isDirectory() && name.endsWith("json")) {
                    String json_str = readJson(f.getPath());
                    if (json_str != "") {
                        result.add(json_str);
                    }

                }
            }
        }
        return result;
    }
}
