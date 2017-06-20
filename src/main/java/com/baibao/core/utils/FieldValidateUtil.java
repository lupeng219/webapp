package com.baibao.core.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;

/**
 * 属性字段验证工具类，只接受map和pojobean
 * 
 * @author yy
 *
 */
public class FieldValidateUtil {

	@SuppressWarnings("rawtypes")
	public static void validateFields(Object o, String[] keys) throws Exception {

		if (o == null || keys == null) {
			throw new BusinessException("参数校验不通过,请核实接口参数正确性");
		}

		if (o instanceof Map) {
			for (String key : keys) {
				Object val = ((Map) o).get(key);
				if (val == null || val == "") {
					throw new BusinessException("参数校验不通过,指定的验证参数[" + key + "]验证不通过");
				}
			}
		} else if (o instanceof List) {
			List list = (List) o;
			if (list.size() == 0) {
				return;
			}
			for (Object bean : list) {
				validateFields(bean, keys);
			}
		} else {
			Class clazz = o.getClass();
			Field[] fields = clazz.getDeclaredFields();// 获取属性字段
			if (fields.length == 0)
				return;
			if (Arrays.asList(keys) != null) {
				List<String> list = Arrays.asList(keys);
				if (list.size() == 0)
					return;
				Map<String, Object> keyvalue = new HashMap<String, Object>();
				for (Field f : fields) {
					String key = f.toString();
					key = key.substring(key.lastIndexOf(".") + 1, key.length());
					f.setAccessible(true);
					Object value = f.get(o);
					keyvalue.put(key, value);
				}
				validateFields(keyvalue, keys);
			}
		}
	}

}
