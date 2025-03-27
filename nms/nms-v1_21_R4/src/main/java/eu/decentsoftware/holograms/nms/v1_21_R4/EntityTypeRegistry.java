package eu.decentsoftware.holograms.nms.v1_21_R4;

import eu.decentsoftware.holograms.nms.api.DecentHologramsNmsException;
import net.minecraft.world.entity.EntityTypes;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;

import java.util.Optional;

final class EntityTypeRegistry {

    private EntityTypeRegistry() {
        throw new IllegalStateException("Utility class");
    }

    static double getEntityTypeHeight(EntityType entityType) {
        return findEntityTypes(entityType).n().b();
    }

    static EntityTypes<?> findEntityTypes(EntityType entityType) {
        NamespacedKey keyOrNull = entityType.getKeyOrNull();
        if (keyOrNull == null) {
            throw new DecentHologramsNmsException("Couldn't get key for entity type: " + entityType);
        }
        String key = keyOrNull.getKey();
        Optional<EntityTypes<?>> entityTypes = EntityTypes.a(key);
        if (entityTypes.isPresent()) {
            return entityTypes.get();
        }
        throw new DecentHologramsNmsException("Invalid entity type: " + entityType);
    }

}
