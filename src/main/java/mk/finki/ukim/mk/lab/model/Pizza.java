package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pizza {
    private String name;
    private String description;


    public boolean matches(String term)
    {
        return this.name.contains(term) || this.description.contains(term);
    }
}
