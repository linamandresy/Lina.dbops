package lina.dbops.object;

import java.lang.reflect.Method;
import java.util.LinkedList;

public class Entity {
	public static LinkedList<String> getAttributes(Object obj) throws Exception {
		Class c = obj.getClass();
		Method[] methods = c.getDeclaredMethods();
		LinkedList<String> getters = getMethodsNameByPrefix(methods, "get");
		LinkedList<String> setters = getMethodsNameByPrefix(methods, "set");
		LinkedList<String> result = new LinkedList<String>();
		for (int i = 0; i < getters.size(); i++) {
			if (isAttribute(getters.get(i), setters))
				result.add(getters.get(i).substring(3));
		}
		return result;
	}

	public static boolean isAttribute(String getter, LinkedList<String> setters) {
		getter = getter.substring(3);
		for (int i = 0; i < setters.size(); i++) {
			if (setters.get(i).endsWith(getter))
				return true;
		}
		return false;
	}

	public static LinkedList<String> getMethodsNameByPrefix(Method[] methods, String prefix) {
		LinkedList<String> result = new LinkedList<String>();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().startsWith(prefix))
				result.add(methods[i].getName());
		}
		return result;
	}

	public static Object getAttributeValue(Object obj, String attributeName) throws Exception {
		String methodName = "get" + attributeName;
		Method meth = obj.getClass().getMethod(methodName, null);
		return meth.invoke(obj, null);
	}
}
