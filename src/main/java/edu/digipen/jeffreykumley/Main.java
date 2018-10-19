package edu.digipen.jeffreykumley;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
	modid = Main.MODID,
	name = Main.NAME,
	version = Main.VERSION,
	acceptedMinecraftVersions = Main.ACCEPTED_VERSIONS
)
public class Main
{
    public static final String MODID = "jeffreykumley";
    public static final String NAME = "Jeffrey's Example Mod";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSIONS = "1.12.2";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        logger.info("PreInitialize event received");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("Initialize event received");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        logger.info("PostInitialize event received");
    }
}
