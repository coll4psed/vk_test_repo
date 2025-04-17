package valueObjects;

import java.util.Objects;

public class GroupProfileData {
    private final String name;

    public GroupProfileData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupProfileData that)) return false;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
