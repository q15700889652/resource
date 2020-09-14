package com.example.demo.util.zxutil;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.dao.master.LoggerMapper;

/**
 * @author 41371
 *
 */
@Controller
public class SelectDataConstructor {
	
	@Autowired
	LoggerMapper loggerMapper;
	/**
	 * 下拉框取值
	 */
	@PostMapping("/logger/logquery1")
	@ResponseBody
	public HashMap<String, Object> getSelectData(String columnCode,String columnName,String table) {
		System.out.println("columnCode:"+columnCode+",table:"+table+",columnName:"+columnName);		
		HashMap<String, Object> hash=new HashMap<>();
		hash.put("code", 0);
		hash.put("msg", "");
		hash.put("count", "");
		hash.put("data",loggerMapper.getSelectData(columnCode,columnName,table));	
		return hash;
		
		}
	
}
