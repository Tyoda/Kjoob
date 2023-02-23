package org.tyoda.wurm.kjoob;

import com.wurmonline.server.behaviours.BehaviourList;
import com.wurmonline.server.items.*;
import com.wurmonline.shared.constants.IconConstants;
import org.gotti.wurmunlimited.modloader.classhooks.HookException;
import org.gotti.wurmunlimited.modloader.interfaces.ItemTemplatesCreatedListener;
import org.gotti.wurmunlimited.modloader.interfaces.PreInitable;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.gotti.wurmunlimited.modsupport.items.ModItems;

import java.io.IOException;

public class Kjoob implements WurmServerMod, ItemTemplatesCreatedListener, PreInitable {
    @Override
    public void preInit() {
        ModItems.init();
    }

    @Override
    public void onItemTemplatesCreated() {
        String modelName = "mod.tyoda.kjoob.Kjoob.";
        ItemTemplateBuilder builder = new ItemTemplateBuilder(modelName)
                .name("Kjoob", "kjoobs", "An ominous cube.")
                .modelName(modelName)
                .itemTypes(new short[]{
                        ItemTypes.ITEM_TYPE_DECORATION
                })
                .imageNumber((short) IconConstants.ICON_CONTAINER_GIFT)
                .behaviourType(BehaviourList.itemBehaviour)
                .decayTime(3024000L)
                .dimensions(80, 30, 50)
                .difficulty(55.0F)
                .weightGrams(4300)
                .material(Materials.MATERIAL_ANIMAL);
        try {
            builder.build();
        } catch (IOException e){
            throw new HookException(e);
        }
    }
}