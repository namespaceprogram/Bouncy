package org.namespace.bouncy.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.namespace.bouncy.Bouncy;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerWalk(PlayerMoveEvent e) {

        if(Bouncy.pl.getConfig().getBoolean("enabled")) {
            Player p = e.getPlayer();
            Location bu = p.getLocation();
            bu.setY(bu.getY() - 1);
            if(p.getLocation().getBlock().getType().equals(Material.valueOf(Bouncy.pl.getConfig().getString("topblock"))) && bu.equals(Material.valueOf(Bouncy.pl.getConfig().getString("underblock")))) {

                p.setVelocity(p.getLocation().getDirection().multiply(Bouncy.pl.getConfig().getInt("velocity-multiplier")).setY(Bouncy.pl.getConfig().getInt("y-velocity")));
                Bouncy.pl.launched_players.add(p);

                if(Bouncy.pl.getConfig().getBoolean("message")) {

                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Bouncy.pl.getConfig().getString("launch-message")));

                }

            }

        }
    }

}
