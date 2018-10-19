package digipen;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

// This class is the class that Forge interacts with. It receives all events from Forge.
@Mod(
	modid = Main.MODID,
	name = Main.NAME,
	version = Main.VERSION,
	acceptedMinecraftVersions = Main.ACCEPTED_VERSIONS
)
public class Main
{
	// If you change the mod ID, you need to change it EVERYWHERE
	// The mod ID must be all lowercase
	// The mod ID is used all over the place
    public static final String MODID = "digipen";
    
    // A quick way of adding the mod ID to something
    // Useful for generating ResourceLocations like textures
    public static String getID(String name) { return MODID + ":" + name; }
    
    // If you change the mod name, you only need to change it here and in resources/mcmod.info
    public static final String NAME = "DigiPen's Example Mod";
    
    // If you change the version, you only need to change it here and in resources/mcmod.info
    // You can set this to whatever you want
    public static final String VERSION = "1.0";
    
    // If you change accepted versions, you only need to change it here and in resources/mcmod.info
    // This is the target version of Minecraft you support
    public static final String ACCEPTED_VERSIONS = "1.12.2";

    // Used to log statements to the console
    private static Logger logger;

    // This is the instance of your mod, which may be a client and may be a server
    @SidedProxy(clientSide="digipen.ClientOnlyProxy", serverSide="digipen.DedicatedServerProxy")
    public static CommonProxy proxy;
    
    // Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	// Get the output for writing to the console
        logger = event.getModLog();
        // Log the current state
        logger.info("PreInitialize event received");
        
        // Pass on the event
        proxy.preInit(event);
    }

    // Do your mod setup. Build whatever data structures you care about. Register recipes, send FMLInterModComms messages to other mods.
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // Log the current state
        logger.info("Initialize event received");
        
        // Pass on the event
        proxy.init(event);
    }

    // Handle interaction with other mods, complete your setup based on this.
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // Log the current state
        logger.info("PostInitialize event received");
        
        // Pass on the event
        proxy.postInit(event);
    }
}
