package com.bsgamestudios.mcmods.airportcomponents;

import com.bsgamestudios.mcmods.airportcomponents.blocks.BlankTarmacBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.Configuration;

@Mod(modid="AirportComponentsMod", name="Airport Components", version="0.0.0.0")
@NetworkMod(clientSideRequired=true)
public class AirportComponents {
	
	public static Block blankTarmacBlock;
	
	@Instance(value = "AirportComponentsMod")
	public static AirportComponents instance;
	
	@SidedProxy(clientSide="com.bsgamestudios.mcmods.airportcomponents.client.ClientProxy", serverSide="com.bsgamestudios.mcmods.airportcomponents.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		Property blankTarmacBlockID = config.get(Configuration.CATEGORY_BLOCK, "blankTarmacBlock", 3520);
		
		config.save();
		
		blankTarmacBlock = new BlankTarmacBlock(Material.rock)
			.setHardness(10F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("blankTarmacBlock").setCreativeTab(CreativeTabs.tabBlock)
			.setResistance(2F).setTextureName("airportcomponents:blankTarmacBlockTexture");
		
		MinecraftForge.setBlockHarvestLevel(blankTarmacBlock, "pickaxe", 1);
		GameRegistry.registerBlock(blankTarmacBlock, "blankTarmacBlock");
		LanguageRegistry.addName(blankTarmacBlock, "Tarmac");
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
