package com.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Equipment {

    NODE(EquipmentType.INPUT),
    TOTE(EquipmentType.BOTH),
    BASKET(EquipmentType.INPUT),
    PALLET(EquipmentType.OUTPUT),
    ROBOT(EquipmentType.INPUT);

    private EquipmentType type;

    private enum EquipmentType {
        INPUT,
        OUTPUT,BOTH
    }

    Equipment(EquipmentType type) {
        this.type = type;
    }

    public EquipmentType getType() {
        return type;
    }

    public List<Equipment> getEquipments(EquipmentType type) {
        return Arrays.stream(Equipment.values()).filter(e -> e.getType().equals(type))
                .collect(Collectors.toUnmodifiableList());

    }
}
