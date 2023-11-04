package com.kot.user.api.backoffice.v1.login;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class LoginV1RequestModel {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof LoginV1RequestModel that)) return false;

        return new EqualsBuilder().append(getEmail(), that.getEmail())
                .append(getPassword(), that.getPassword())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getEmail())
                .append(getPassword())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "LoginV1RequestModel{" +
                "email='" + email + '\'' +
                '}';
    }
}
