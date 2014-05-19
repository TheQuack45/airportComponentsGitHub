package com.bsgamestudios.mcmods.airportcomponents.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.client.renderer.texture.IconRegister;

public class SmallLineTarmacBlock extends Block {
	
	Icon smallLineTarmacTexture, blankTarmacTexture;
	
	public SmallLineTarmacBlock (Material material) {
		super(3521, material);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IconRegister iconRegister) {
		smallLineTarmacTexture = iconRegister.registerIcon("airportcomponents:smallLineTarmacBlockTexture");
		blankTarmacTexture = iconRegister.registerIcon("airportcomponents:blankTarmacBlockTexture");
	}
	
	public Icon getItem(int meta, int side) {
		if (side == 1) {
			return smallLineTarmacTexture;
		} else {
			return blankTarmacTexture;
		}
	}
}