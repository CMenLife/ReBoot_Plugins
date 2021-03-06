package com.hanriel.reboot_auth.bridge.bungee;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import com.hanriel.reboot_auth.Shop;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class BungeeCordUtils {

	public static boolean connect(Player player, String server) {
		
		try {
			
			if (server.length() == 0) {
				player.sendMessage("�cTarget server was \"\" (empty string) cannot connect to it.");
				return false;
			}
		
			ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
			DataOutputStream out = new DataOutputStream(byteArray);
		 
			out.writeUTF("Connect");
			out.writeUTF(server); // Target Server.
		    
			player.sendPluginMessage(Shop.getInstance(), "BungeeCord", byteArray.toByteArray());
			
		} catch (Exception ex) {
			player.sendMessage(ChatColor.RED + "An unexpected exception has occurred. Please notify the server's staff about this. (They should look at the console).");
			ex.printStackTrace();
			Shop.getInstance().getLogger().warning("Could not connect \"" + player.getName() + "\" to the server \"" + server + "\".");
			return false;
		}
		
		return true;
	}
	
}
