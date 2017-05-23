package com.yjy.maven.datasource;

public class DatabaseContextHolder {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public final static String DATA_SOURCE_CRMTEST = "dataSourceA";
	public final static String DATA_SOURCE_ACTPAR1 = "dataSourceB";

	public static void setCustomerType(String customerType) {
		contextHolder.set(customerType);
	}

	public static String getCustomerType() {
		return contextHolder.get();
	}

	public static void clearCustomerType() {
		contextHolder.remove();
	}
}
