import annotations.Ignored;

import java.lang.reflect.Field;
import java.util.List;

import static enums.JSON_PREFFIXES.*;

public class JsonGenerator {

    public static String getJson(Object object) throws IllegalAccessException {
        StringBuilder jsonObject = new StringBuilder(OBJECT_PREFIX.value());

        Field[] fields = object.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {

            fields[i].setAccessible(true);
            String attribute = "";
            if (fields[i].getType().equals(List.class))
                attribute = STRING_PREFIX.value() + fields[i].getName() + STRING_SUFFIX.value() + ":" + getListJson(fields[i], object);
            else attribute = buildBasicJsonAttribute(fields[i], object);

            jsonObject.append(attribute);
            if (i < (fields.length - 1)) jsonObject.append(SEPARATOR.value());

        }
        jsonObject.append(OBJECT_SUFFIX.value());
        return jsonObject.toString();
    }

    private static String getListJson(Field field, Object object) throws IllegalAccessException {
        StringBuilder jsonListObject = new StringBuilder(LIST_PREFIX.value());
        List<Object> fields = (List<Object>) field.get(object);

        for (int i = 0; i < fields.size(); i++) {
            Object tmpField = fields.get(i);

            if (!isEqualType(tmpField, String.class)
                    && !isEqualType(tmpField, Integer.class)
                    && !isEqualType(tmpField, Double.class)
                    && !isEqualType(tmpField, Boolean.class)
                    && !isEqualType(tmpField, Float.class)
                    && !isEqualType(tmpField, Enum.class)) {
                jsonListObject.append(buildBasicJsonObject(tmpField));
            } else {
                jsonListObject.append(buildBasicJsonAttribute(field, object));
            }

            if (i < (fields.size() - 1)) jsonListObject.append(SEPARATOR.value());
        }
        jsonListObject.append(LIST_SUFFIX.value());
        return jsonListObject.toString();
    }

    private static String buildBasicJsonObject(Object value) throws IllegalAccessException {
        StringBuilder jsonObject = new StringBuilder(OBJECT_PREFIX.value());
        Field[] declaredFields = value.getClass().getDeclaredFields();

        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            jsonObject.append(buildBasicJsonAttribute(declaredFields[i], value));
            if (i != (declaredFields.length - 1)) jsonObject.append(SEPARATOR.value());
        }

        jsonObject.append(OBJECT_SUFFIX.value());
        return jsonObject.toString();

    }

    private static String buildBasicJsonAttribute(Field field, Object value) throws IllegalAccessException {
        if (field.getAnnotation(Ignored.class) == null) {
            boolean isString = String.class.equals(field.getType());
            String attributeName = STRING_PREFIX.value() + field.getName() + STRING_SUFFIX.value();
            Object attributeValue = isString
                    ? STRING_PREFIX.value() + field.get(value) + STRING_SUFFIX.value()
                    : field.get(value);

            return attributeName + ":" + attributeValue;
        }
        return "";

    }

    private static Boolean isEqualType(Object field, Class type) {
        return field.getClass().getTypeName().equals(type.getTypeName());
    }

}
