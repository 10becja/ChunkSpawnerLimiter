package com.cyprias.ChunkSpawnerLimiter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import com.cyprias.ChunkSpawnerLimiter.listeners.EntityListener;
import com.cyprias.ChunkSpawnerLimiter.listeners.WorldListener;

public class Plugin extends JavaPlugin {
	private static Plugin instance = null;
	public static String chatPrefix = "&4[&bCSL&4]&r ";

	public static HashMap<String, Location> deaths = new HashMap<String, Location>();

	public void onEnable() {
		instance = this;

		// Check if config.yml exists on disk, copy it over if not. This keeps
		// our comments intact.
		if (!(new File(getDataFolder(), "config.yml").exists())) {
			Logger.info(chatPrefix + "Copying config.yml to disk.");
			try {
				YML.toFile(getResource("config.yml"), getDataFolder(), "config.yml");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}

		// Register our event listener.
		getServer().getPluginManager().registerEvents(new EntityListener(), this);
		getServer().getPluginManager().registerEvents(new WorldListener(), this);
	}

	public void onDisable() {
		getServer().getScheduler().cancelTasks(this);
	}
	
	public static final Plugin getInstance() {
		return instance;
	}


	public static int scheduleSyncRepeatingTask(Runnable run, long delay) {
		return scheduleSyncRepeatingTask(run, delay, delay);
	}
	public static int scheduleSyncRepeatingTask(Runnable run, long start, long delay) {
		return instance.getServer().getScheduler().scheduleSyncRepeatingTask(instance, run, start, delay);
	}
	public static void cancelTask(int taskID) {
		instance.getServer().getScheduler().cancelTask(taskID);
	}
	
	
}
