package com.bsgamestudios.mcmods.airportcomponents;

import com.bsgamestudios.mcmods.airportcomponents.blocks.BlankTarmacBlock;
import com.bsgamestudios.mcmods.airportcomponents.blocks.SmallLineTarmacBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.Configuration;
import net.minecraft.util.Icon;

@Mod(modid="AirportComponentsMod", name="Airport Components", version="0.0.0.0")
@NetworkMod(clientSideRequired=true)
public class AirportComponents {
	
	public static Block blankTarmacBlock;
	public static Block smallLineTarmacBlock;
	Icon smallLineTarmacBlockTextureTop, blankTarmacBlockTexture;
	
	@Instance(value = "AirportComponentsMod")
	public static AirportComponents instance;
	
	@SidedProxy(clientSide="com.bsgamestudios.mcmods.airportcomponents.client.ClientProxy", serverSide="com.bsgamestudios.mcmods.airportcomponents.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		Property blankTarmacBlockID = config.get(Configuration.CATEGORY_BLOCK, "blankTarmacBlock", 3520);
		Property smallLineTarmacBlockID = config.get(Configuration.CATEGORY_BLOCK, "smallLineTarmacBlock", 3521);
		
		config.save();
		
		blankTarmacBlock = new BlankTarmacBlock(Material.rock)
			.setHardness(2F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("blankTarmacBlock").setCreativeTab(CreativeTabs.tabBlock)
			.setResistance(10F).setTextureName("airportcomponents:blankTarmacBlockTexture");
		MinecraftForge.setBlockHarvestLevel(blankTarmacBlock, "pickaxe", 1);
		
		smallLineTarmacBlock = new SmallLineTarmacBlock(Material.rock)
			.setHardness(2F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("smallLineTarmacBlock").setCreativeTab(CreativeTabs.tabBlock)
			.setResistance(10F).setTextureName("airportcomponents:smallLineTarmacBlockTexture");
		MinecraftForge.setBlockHarvestLevel(smallLineTarmacBlock, "pickaxe", 1);
		
		GameRegistry.registerBlock(blankTarmacBlock, "blankTarmacBlock");
		LanguageRegistry.addName(blankTarmacBlock, "Tarmac");
		GameRegistry.registerBlock(smallLineTarmacBlock, "smallLineTarmacBlock");
		LanguageRegistry.addName(smallLineTarmacBlock, "Solid Line Tarmac");
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
