package ru.job4j.magnit;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author madrabit
 * Create XML from Database data.
 */
public class XmlUsage {
    @XmlRootElement(name = "entries")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Entries {
        @XmlElement(name = "entry")
        private List<Field> entry;

        public Entries() {
        }

        public Entries(List<Field> entry) {
            this.entry = entry;
        }

        public List<Field> getEntry() {
            return entry;
        }

        public void setEntry(List<Field> entry) {
            this.entry = entry;
        }
    }

    @XmlRootElement(name = "entry")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Field {
        @XmlElement(name = "field")
        private int field;

        public Field() {
        }

        public Field(int field) {
            this.field = field;
        }

        public int getField() {
            return field;
        }

        public void setField(int field) {
            this.field = field;
        }
    }
}
