package org.namespace.bouncy;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.namespace.bouncy.listeners.FallDamageListener;
import org.namespace.bouncy.listeners.PlayerMoveListener;

import java.util.ArrayList;

public final class Bouncy extends JavaPlugin {

    public static Bouncy pl;

    public ArrayList<Player> launched_players = new ArrayList<>();

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getServer().getPluginManager().registerEvents(new FallDamageListener(), this);

        pl = this;

    }

}
