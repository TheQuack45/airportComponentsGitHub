package com.bsgamestudios.mcmods.airportcomponents.blocks;

import com.bsgamestudios.mcmods.airportcomponents.AirportComponents;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraftforge.common.Property;

import java.util.Random;

public class BlankTarmacBlock extends Block {
	
	public BlankTarmacBlock (Material material) {
		super(3520, material);
	}
}