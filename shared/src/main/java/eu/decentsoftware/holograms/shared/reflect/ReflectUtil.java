package eu.decentsoftware.holograms.shared.reflect;

import com.google.common.reflect.TypeToken;
import eu.decentsoftware.holograms.shared.DecentHologramsException;

import java.lang.reflect.Field;

public final class ReflectUtil {

    private ReflectUtil() {
        throw new IllegalAccessError("Utility class");
    }

    /**
     * Get the value of a static field in a class.
     *
     * @param clazz     The class that has the field.
     * @param fieldName The name of the field.
     * @param <T>       Type of the field.
     * @return The value of the field.
     */
    public static <T> T getFieldValue(Class<?> clazz, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(null);
        } catch (NoSuchFieldException e) {
            throw new DecentHologramsException("Could not find field " + fieldName + " in class " + clazz.getName(), e);
        } catch (IllegalAccessException e) {
            throw new DecentHologramsException("Could not access field " + fieldName + " in class "
                    + clazz.getName(), e);
        } catch (ClassCastException e) {
            Class<?> expectedFieldType = new TypeToken<T>() {
            }.getRawType();
            throw new DecentHologramsException("Could not cast value of field " + fieldName + " in class "
                    + clazz.getName() + " to " + expectedFieldType.getName(), e);
        } catch (Exception e) {
            throw new DecentHologramsException("Unexpected error occurred while getting value of field " + fieldName
                    + " in class " + clazz.getName(), e);
        }
    }

}
