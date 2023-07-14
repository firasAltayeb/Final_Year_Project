package com.mygdx.game;

/**
 * Created by firasAltayeb on 25/02/2017.
 */

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class MyPacker {
	public static void main (String[] args) throws Exception {

		String inputDir = "core/assets/hiro";
		String outputDir = "core/assets/packed";
		String packFileName = "hiro_sheet";

		TexturePacker.process(inputDir, outputDir, packFileName);
	}
}
