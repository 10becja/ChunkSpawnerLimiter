package com.cyprias.ChunkSpawnerLimiter;

import java.util.List;

public class Config {
	public static boolean getBoolean(String property) {
		return Plugin.getInstance().getConfig().getBoolean(property);
	}

	public static int getInt(String property) {
		return Plugin.getInstance().getConfig().getInt(property);
	}
	
	public static String getString(String property) {
		return Plugin.getInstance().getConfig().getString(property);
	}

	public static String getString(String property, Object... args) {
		return String.format(Plugin.getInstance().getConfig().getString(property), args);
	}

	
	public static boolean contains(String property) {
		return Plugin.getInstance().getConfig().contains(property);
	}
	
	public static  List<String> getStringList(String property) {
		return Plugin.getInstance().getConfig().getStringList(property);
	}
}
