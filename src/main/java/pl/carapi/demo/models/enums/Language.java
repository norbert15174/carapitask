package pl.carapi.demo.models.enums;

import com.google.common.base.Strings;

public enum Language {
    EN("en"), PL("pl");

    Language(String value) {
        this.value = value;
    }

    private String value;

    public static Language getLanguage(String lang) {
        return Strings.isNullOrEmpty(lang) || !PL.value.equals(lang.toLowerCase()) ? EN : PL;
    }
}
