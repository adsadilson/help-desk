package model.enums;

import java.util.Arrays;

public enum ProfileEnum {
    ROLE_ADMIN("ADMIN"),
    ROLE_CUSTOMER("CLIENTE"),
    ROLE_TECHNICIAN("TECNICO");

    private String description;

    ProfileEnum(String description) {
        this.description = description;
    }

    public static ProfileEnum toEnum(final String description) {
        return Arrays.stream(ProfileEnum.values())
                .filter(profileEnum -> profileEnum.description.equalsIgnoreCase(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid description " + description));
    }

    public String getDescription() {
        return description;
    }
}
