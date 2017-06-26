package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.docx4j.Docx4J;
import org.docx4j.convert.out.HTMLSettings;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.DataProvider;

@Component
public class Test {
	@DataProvider
	public Collection<Map<String, Object>> loadDatas() {
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("id", RandomUtils.nextInt());
			map1.put("name", RandomStringUtils.random(2,
					"秋白南风醉山初彤凝海紫文凌晴香卉雅琴傲安傲之初蝶寻桃代芹诗霜春柏绿夏碧灵诗柳夏柳采白慕梅乐安冬菱紫安宛凝雨雪易真安荷静竹飞雪雪兰雅霜从蓉冷雪靖巧翠丝觅翠凡白乐蓉迎波丹烟梦旋书双念桃夜天海桃青香恨风安筠觅柔初南秋蝶千易安露诗蕊山雁友菱香露晓兰涵瑶秋柔思菱萧何》"));
			dataList.add(map1);
		}
		ClassloaderUtil.getCurrentClassloaderDetail();
		return dataList;
	}

	public static void main(String[] args) throws Exception {
		String path = "D:\\projects\\nuoya\\Document\\2.需求文档\\tt.docx";
		InputStream is = new FileInputStream(new File(path));
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(is);
		HTMLSettings htmlSettings = Docx4J.createHTMLSettings();
    	htmlSettings.setWmlPackage(wordMLPackage);
    	OutputStream os = new FileOutputStream(path + ".html");
		Docx4J.toHTML(htmlSettings, os, Docx4J.FLAG_EXPORT_PREFER_NONXSL);
		os.close();
	}
}
