package me.ozaii.expert.coin.expercoins;

import me.ozaii.expert.coin.expercoins.PlaceHolders.ExpercoinsPlaceholderExpansion;
import me.ozaii.expert.coin.expercoins.commands.coin.*;
import me.ozaii.expert.coin.expercoins.commands.exp.ExpAdminCommands;
import me.ozaii.expert.coin.expercoins.commands.exp.ExpCommands;
import me.ozaii.expert.coin.expercoins.commands.level.TopLevelCommand;
import me.ozaii.expert.coin.expercoins.commands.profil.ProfilCommand;
import me.ozaii.expert.coin.expercoins.commands.level.Level;
import me.ozaii.expert.coin.expercoins.commands.level.LevelCommands;
import me.ozaii.expert.coin.expercoins.commands.profil.ProfileCommands;
import me.ozaii.expert.coin.expercoins.listeners.LevelUpEvent;
import me.ozaii.expert.coin.expercoins.listeners.PlayerTableCreateListener;
import me.ozaii.expert.coin.expercoins.managers.*;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Expercoins extends JavaPlugin {
    private static Expercoins isntance;
    private  ConfigManager configManager;
    private  DatabaseManager databaseManager;
    private  CoinManager coinManager;
    private ProfileManager profileManager;
    private ExpManager expManager;
    private LevelManager levelManager;
    private ReawardManager reawardManager;
    private DatabaseManager2 databaseManager2;
    @Override
    public void onEnable() {
        isntance = this;
        getLogger().info("ExperCoin is enable");
        configManager=new ConfigManager(this);
        configManager.setupConfig();
        databaseManager=new DatabaseManager(this,configManager);
        databaseManager.createTable();
        coinManager=new CoinManager(this,databaseManager);
        profileManager=new ProfileManager(this,databaseManager);
        expManager=new ExpManager(databaseManager,levelManager);
        levelManager=new LevelManager(databaseManager,100,1);
        reawardManager=new ReawardManager(coinManager,expManager);
        databaseManager2=new DatabaseManager2(this,configManager);
        databaseManager2.createTable();
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new ExpercoinsPlaceholderExpansion(this, coinManager, levelManager, expManager, profileManager).register();
        }
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerTableCreateListener(databaseManager, coinManager, levelManager, expManager, profileManager), this);
        Bukkit.getServer().getPluginManager().registerEvents(new LevelUpEvent(this,expManager,levelManager), this);

        //coin
        getCommand("coinim").setExecutor(new Coin(coinManager));
        getCommand("topcoin").setExecutor(new TopCoinCommand(coinManager));
        getCommand("c").setExecutor(new CoinCommands(coinManager));
        getCommand("coinyolla").setExecutor(new CoinYollaCommand(coinManager));
        getCommand("flipcoin").setExecutor(new FlipCoinCommand(coinManager));
        //level
        getCommand("levelim").setExecutor(new Level(levelManager));
        getCommand("l").setExecutor(new LevelCommands(levelManager));
        getCommand("toplevel").setExecutor(new TopLevelCommand(levelManager));
        //exp
        getCommand("expim").setExecutor(new ExpCommands(expManager));
        getCommand("e").setExecutor(new ExpAdminCommands(expManager));
        //profile
        getCommand("p").setExecutor(new ProfileCommands(profileManager, coinManager, levelManager, expManager));
        getCommand("profil").setExecutor(new ProfilCommand(profileManager, coinManager, levelManager, expManager));
    }

    @Override
    public void onDisable() {}

    public static Expercoins getIsntance() {return isntance;}
    public DatabaseManager getDatabaseManager(){return databaseManager;}
    public CoinManager getCoinManager() {return coinManager;}
    public ConfigManager getConfigManager(){return  configManager;}
    public ProfileManager getProfileManager() {return profileManager;}
    public LevelManager getLevelManager(){return levelManager;}
    public ReawardManager getReawardManager(){return reawardManager;}
    public ExpManager getExpManager(){return  expManager;}
    private DatabaseManager2 getDatabaseManager2(){return databaseManager2;}
}
