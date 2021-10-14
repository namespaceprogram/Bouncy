package org.namespace.bouncy.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.namespace.bouncy.Bouncy;

public class FallDamageListener implements Listener {

    @EventHandler
    public void onFallDamage(EntityDamageEvent e) {

        if(e.getCause().equals(EntityDamageEvent.DamageCause.FALL) && Bouncy.pl.getConfig().getBoolean("fall-damage") == false) {
            if(Bouncy.pl.launched_players.contains(e.getEntity())) {
                e.setCancelled(true);
                Bouncy.pl.launched_players.remove(e.getEntity());
            }
        }

    }

}
