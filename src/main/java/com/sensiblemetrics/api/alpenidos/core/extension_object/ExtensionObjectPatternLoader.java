package com.sensiblemetrics.api.alpenidos.core.extension_object;

import com.sensiblemetrics.api.alpenidos.core.extension_object.iface.CommanderExtension;
import com.sensiblemetrics.api.alpenidos.core.extension_object.iface.SergeantExtension;
import com.sensiblemetrics.api.alpenidos.core.extension_object.iface.SoldierExtension;
import com.sensiblemetrics.api.alpenidos.core.extension_object.model.CommanderUnit;
import com.sensiblemetrics.api.alpenidos.core.extension_object.model.SergeantUnit;
import com.sensiblemetrics.api.alpenidos.core.extension_object.model.SoldierUnit;
import com.sensiblemetrics.api.alpenidos.core.extension_object.model.Unit;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * Anticipate that an object’s interface needs to be extended in the future.
 * Additional interfaces are defined by extension objects.
 */
@Slf4j
public class ExtensionObjectPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        //Create 3 different units
        final Unit soldierUnit = new SoldierUnit("SoldierUnit1");
        final Unit sergeantUnit = new SergeantUnit("SergeantUnit1");
        final Unit commanderUnit = new CommanderUnit("CommanderUnit1");

        //check for each unit to have an extension
        checkExtensionsForUnit(soldierUnit);
        checkExtensionsForUnit(sergeantUnit);
        checkExtensionsForUnit(commanderUnit);

    }

    private static void checkExtensionsForUnit(final Unit unit) {
        final SoldierExtension soldierExtension = (SoldierExtension) unit.getUnitExtension("SoldierExtension");
        final SergeantExtension sergeantExtension = (SergeantExtension) unit.getUnitExtension("SergeantExtension");
        final CommanderExtension commanderExtension = (CommanderExtension) unit.getUnitExtension("CommanderExtension");

        //if unit have extension call the method
        Optional.ofNullable(soldierExtension).ifPresentOrElse(SoldierExtension::soldierReady, () -> log.info(unit.getName() + " without SoldierExtension"));
        Optional.ofNullable(sergeantExtension).ifPresentOrElse(SergeantExtension::sergeantReady, () -> log.info(unit.getName() + " without SergeantExtension"));
        Optional.ofNullable(commanderExtension).ifPresentOrElse(CommanderExtension::commanderReady, () -> log.info(unit.getName() + " without CommanderExtension"));
    }
}
