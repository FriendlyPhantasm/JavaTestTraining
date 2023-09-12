package ru.stqa.pft.addressbook.model;


import java.util.Objects;

public class GroupData {
    private final String id;
    private final String name;
    private final String header;
    private final String footer;

    public GroupData(String name , String header, String footer) {
        this.id = null;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public GroupData(String id, String name , String header, String footer) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFooter() {
        return footer;
    }

    public String getHeader() {
        return header;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, header, footer);
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }
}

/*public record GroupData(String id, String name, String header, String footer) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(id, groupData.id) && Objects.equals(name, groupData.name) && Objects.equals(header, groupData.header) && Objects.equals(footer, groupData.footer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, header, footer);
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}

public record GroupData(String name, String header, String footer) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(id, groupData.id) && Objects.equals(name, groupData.name) && Objects.equals(header, groupData.header) && Objects.equals(footer, groupData.footer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, header, footer);
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}*/

