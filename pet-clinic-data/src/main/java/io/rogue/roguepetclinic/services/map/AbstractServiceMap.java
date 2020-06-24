package io.rogue.roguepetclinic.services.map;

import io.rogue.roguepetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractServiceMap<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    T findById(ID id) {
        return map.get(id);
    }

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object can not be null");
        }
        return object;
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId() {
        if (!map.isEmpty()) {
            return Collections.max(map.keySet()) + 1;
        }
        return 1L;
    }
}
