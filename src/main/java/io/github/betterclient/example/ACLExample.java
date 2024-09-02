package io.github.betterclient.example;

import io.github.betterclient.acl.AscendConfigLibrary;
import io.github.betterclient.acl.CustomModBuilder;
import io.github.betterclient.acl.CustomOptionBuilder;

import java.awt.*;

public class ACLExample {
    public void onAscend() {
        if (AscendConfigLibrary.detect()) {
            CustomModBuilder.builder()
                    .setModName("Test Mod")
                    .setSaveFunction(enabled -> {
                        //Save mod state to config
                    })
                    .setLoadFunction(() -> {
                        //Load mod state from config
                        return false;
                    })
                    //All method calls from here aren't required.
                    .setCustomToggle(newState -> true)
                    .addOptions(CustomOptionBuilder.builder()
                            .addIntegerOption("Integer Option", () -> {
                                //Load data from config
                                return 0;
                            }, 0, 100, integer -> {
                                //Save data to config
                            })

                            .addDropdownOption("Dropdown Option", () -> {
                                //Load data from config
                                return "Mode1";
                            }, string -> {;
                                //Save data to config
                            }, "Mode1", "Mode2", "Mode3")

                            .addColorOption("Color option", () -> {
                                //Load data from config
                                return Color.WHITE;
                            }, integer -> {
                                //Save data to config
                            })

                            .addSpace("Category Name")

                            .addKeyBindOption("KeyBind option", () -> {
                                //Load data from config
                                return 65;
                            }, integer -> {
                                //Save data to config
                            }, () -> {
                                //On keybind pressed
                            }, () -> {
                                //On keybind un-pressed
                            })
                    )
            .register();
        }
    }
}
