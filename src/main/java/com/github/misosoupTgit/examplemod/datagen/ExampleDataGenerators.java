package com.github.misosoupTgit.examplemod.datagen;

import com.github.misosoupTgit.examplemod.ExampleMod;
import com.github.misosoupTgit.examplemod.datagen.client.ENUSLanguageProvider;
import com.github.misosoupTgit.examplemod.datagen.client.ExampleBlockStateProvider;
import com.github.misosoupTgit.examplemod.datagen.client.ExampleItemModelProvider;
import com.github.misosoupTgit.examplemod.datagen.client.JAJPLanguageProvider;
import com.github.misosoupTgit.examplemod.datagen.server.ExampleBlockTagsProvider;
import com.github.misosoupTgit.examplemod.datagen.server.ExampleRecipeProvider;
import com.github.misosoupTgit.examplemod.datagen.server.loot.ExampleLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

        //client
        generator.addProvider(event.includeClient(),new ExampleItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(),new ExampleBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(),new ENUSLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(),new JAJPLanguageProvider(packOutput));

        // server
        generator.addProvider(event.includeServer(),new ExampleRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), ExampleLootTables.create(packOutput));
        generator.addProvider(event.includeServer(), new ExampleBlockTagsProvider(packOutput,lookUpProvider,existingFileHelper));
    }
}
