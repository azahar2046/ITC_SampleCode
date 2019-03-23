package com.itc.qa.automat.common;

public class Enums {

    public enum JobType{

        Temporary("Temporary/Contract"),
        Permanent("Permanent"),
        Both(" Both");

        private final String visibleText;

        private JobType(String visibleText) {

            this.visibleText = visibleText;
        }

        public String getVisibleText() {

            return visibleText;
        }
    }

    public enum employmentType{

        Both("Both"),
        Full_time("Full time"),
        Part_time("Part time");

        private final String visibleText;

        private employmentType(String visibleText) {

            this.visibleText = visibleText;
        }

        public String getVisibleText() {

            return visibleText;
        }
    }

    public enum Gender{

        Female("Female"),
        Male("Male"),
        Prefer_not_to_specify("Prefer not to specify");

        private final String visibleText;

        private Gender(String visibleText) {

            this.visibleText = visibleText;
        }

        public String getVisibleText() {

            return visibleText;
        }
    }
}
