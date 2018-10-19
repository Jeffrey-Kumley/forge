package digipen;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

// This is the generic version of your mod, which may be a client and may be a server
// All the code that needs to run on both the client and the server to set up the mod should be here
public abstract class CommonProxy
{
	public static ModBlock ruby_block;  // this holds the unique instance of your block
	public static ItemBlock item_ruby_block;  // this holds the unique instance of the ItemBlock corresponding to your block

	public void preInit(FMLPreInitializationEvent event)
	{
		// each instance of your block should have two names:
	    // 1) a registry name that is used to uniquely identify this block.  Should be unique within your mod.  use lower case.
	    // 2) an 'unlocalised name' that is used to retrieve the text name of your block in the player's language.  For example-
	    //    the unlocalised name might be "water", which is printed on the user's screen as "Wasser" in German or
	    //    "aqua" in Italian.
	    //
	    //    Multiple blocks can have the same unlocalised name - for example
	    //  +----RegistryName----+---UnlocalisedName----+
	    //  |  flowing_water     +       water          |
	    //  |  stationary_water  +       water          |
	    //  +--------------------+----------------------+
	    //
		ruby_block = (ModBlock)(new ModBlock().setUnlocalizedName("ruby_block_unlocalised_name"));
		ruby_block.setRegistryName("ruby_block_registry_name");
	    ForgeRegistries.BLOCKS.register(ruby_block);

	    // We also need to create and register an ItemBlock for this block otherwise it won't appear in the inventory
	    item_ruby_block = new ItemBlock(ruby_block);
	    item_ruby_block.setRegistryName(ruby_block.getRegistryName());
	    ForgeRegistries.ITEMS.register(item_ruby_block);
	}
	public void init(FMLInitializationEvent event)
	{
		
	}
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}

	// Returns true if the player is in creative mode or false if not
	public abstract boolean playerIsInCreativeMode(EntityPlayer player);
	
	// Returns true this is a dedicated server or false if a client
	public abstract boolean isDedicatedServer();
}
