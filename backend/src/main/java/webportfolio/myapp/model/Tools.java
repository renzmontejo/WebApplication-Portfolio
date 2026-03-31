package webportfolio.myapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tools")
public class Tools {
    @Id
    @Column(name = "tool_id")
    private Long id;

    @Column(name = "tool_name")
    private String toolName;
}
