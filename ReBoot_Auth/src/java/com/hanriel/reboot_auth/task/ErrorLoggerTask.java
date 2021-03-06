package com.hanriel.reboot_auth.task;

import com.hanriel.reboot_auth.util.ErrorLogger;
import com.hanriel.reboot_auth.util.Utils;
import org.bukkit.ChatColor;

import java.util.List;

public class ErrorLoggerTask implements Runnable {

    private ErrorLogger errorLogger;

    public ErrorLoggerTask(ErrorLogger errorLogger) {
        this.errorLogger = errorLogger;
    }

    @Override
    public void run() {

        List<String> lines = Utils.newArrayList();

        lines.add(" ");
        lines.add(ChatColor.RED + "#----------------------- RB Shop Errors -----------------------#");
        int count = 1;
        for (String error : errorLogger.getErrors()) {
            lines.add(ChatColor.GRAY + "" + (count++) + ") " + ChatColor.WHITE + error);
        }
        lines.add(ChatColor.RED + "#-------------------------------------------------------------#");

        String output = Utils.join(lines, "\n");
        System.out.println(ChatColor.stripColor(output));
    }

}
