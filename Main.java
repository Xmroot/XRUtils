import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.connorlinfoot.titleapi.TitleAPI;

public class Main extends JavaPlugin {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("gm")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Este comando só pode ser executado por um jogador.");
                return false;
            }
            Player player = (Player) sender;
            if (!player.hasPermission("redehid.gm")) {
                player.sendMessage(ChatColor.RED + "Você não tem permissão para usar este comando.");
                return true;
            }
            if(args[0].equals("0")) {
                player.setGameMode(GameMode.SURVIVAL);
                TitleAPI.sendTitle(player, 10, 40, 10, ChatColor.YELLOW + "Modo jogo alterado!", null);
            } else if(args[0].equals("1")) {
                player.setGameMode(GameMode.CREATIVE);
                TitleAPI.sendTitle(player, 10, 40, 10, ChatColor.GREEN + "Modo jogo alterado!", null);
            }
            return true;
        }
        return false;
    }
}
