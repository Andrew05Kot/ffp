package com.kot.dish.bll.filtering;

import java.io.Serializable;

public record FilteringCriteria(String key, FilteringOperation operation, Object value) implements Serializable {

    public Class<?> getType() {
        return value == null ? null : value.getClass();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilteringCriteria that = (FilteringCriteria) o;

        if (key() != null ? !key().equals(that.key()) : that.key() != null) return false;
        if (operation() != null ? !operation().equals(that.operation()) : that.operation() != null)
            return false;
        return value() != null ? value().equals(that.value()) : that.value() == null;
    }

    @Override
    public int hashCode() {
        int result = key() != null ? key().hashCode() : 0;
        result = 31 * result + (operation() != null ? operation().hashCode() : 0);
        result = 31 * result + (value() != null ? value().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "key='" + key + '\'' +
                ", operation=" + operation +
                ", value=" + value +
                '}';
    }
}
